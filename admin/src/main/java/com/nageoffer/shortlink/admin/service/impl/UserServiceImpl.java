package com.nageoffer.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nageoffer.shortlink.admin.common.convention.exception.ClientException;
import com.nageoffer.shortlink.admin.common.convention.result.Result;
import com.nageoffer.shortlink.admin.common.enums.UserErrorCodeEnum;
import com.nageoffer.shortlink.admin.dao.entity.UserDO;
import com.nageoffer.shortlink.admin.dao.mapper.UserMapper;
import com.nageoffer.shortlink.admin.dto.req.UserLoginReqDTO;
import com.nageoffer.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.nageoffer.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserRespDTO;
import com.nageoffer.shortlink.admin.service.GroupService;
import com.nageoffer.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import cn.hutool.core.lang.UUID;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


import java.util.concurrent.TimeUnit;

import static com.nageoffer.shortlink.admin.common.constant.RedisCacheConstant.LOCK_USER_REGISTER_KEY;
import static com.nageoffer.shortlink.admin.common.constant.RedisCacheConstant.USER_LOGIN_KEY;
import static com.nageoffer.shortlink.admin.common.enums.UserErrorCodeEnum.*;

/**
 * ClassName:UserServiceImpl
 * Description:
 * 用户接口实现层
 * @Author DubPAN
 * @Create2024/5/18 16:17
 * @Version 1.0
 */
@Service
@RequiredArgsConstructor //使用构造器方法进行注入
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
    //配合@RequiredArgsConstructor 使用构造器方法进行注入
    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;
    //使用Redission的分布式锁
    private final RedissonClient redissonClient;
    //redis依赖，存储用户登录信息
    private final StringRedisTemplate stringRedisTemplate;
    //用户注册后设置短链接默认分组
    private final GroupService groupService;
    @Override
    public UserRespDTO getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        if (userDO == null){//测试全局异常拦截器
            throw new ClientException(UserErrorCodeEnum.USER_NULL);
        }
        UserRespDTO result = new UserRespDTO();
        BeanUtils.copyProperties(userDO,result);
        return result;
    }

    @Override
    public Boolean hasUsername(String username) {
        //使用布隆过滤器进行判断用户是否存在,存在返回false
        return !userRegisterCachePenetrationBloomFilter.contains(username);
    }

    @Override
    public void register(UserRegisterReqDTO requestParam) {
        if(!hasUsername(requestParam.getUsername())){
            throw new ClientException(USER_NAME_EXIST);
        }
        //通过分布式锁，锁定用户名进行串行执行，防止恶意请求利用未注册用户名将请求打到数据库。
        RLock lock = redissonClient.getLock(LOCK_USER_REGISTER_KEY+requestParam.getUsername());
        try {
            if (lock.tryLock()){
                try {
                    int inserted = baseMapper.insert(BeanUtil.toBean(requestParam, UserDO.class));
                    if(inserted<1){
                        throw new ClientException(USER_SAVE_ERROR);
                    }
                }catch (DuplicateKeyException ex){//重复注册
                    throw new ClientException(USER_EXIST);
                }

                //对用户名使用布隆过滤器加载缓存，判断用户是否存在
                userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
                groupService.saveGroup("默认分组");
                return;//获取到锁，结束
            }
            throw  new ClientException(USER_NAME_EXIST);//没获取到锁，抛出异常：用户名已存在
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void update(UserUpdateReqDTO requestParam) {
        // TODO 验证当前用户名是否为登录用户
        LambdaUpdateWrapper<UserDO> updateWrapper = Wrappers.lambdaUpdate(UserDO.class)
                .eq(UserDO::getUsername, requestParam.getUsername());
        baseMapper.update(BeanUtil.toBean(requestParam,UserDO.class),updateWrapper);
    }

    @Override
    public UserLoginRespDTO login(UserLoginReqDTO requestParam) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, requestParam.getUsername())
                .eq(UserDO::getPassword, requestParam.getPassword())
                .eq(UserDO::getDelFlag, 0);//未被删除的
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        if (userDO == null){
            throw new ClientException("用户不存在！");
        }
        Boolean hasLogin =stringRedisTemplate.hasKey("login"+requestParam.getUsername());
        if(hasLogin!=null && hasLogin){
            throw new ClientException("用户已登录！");
        }
        //存储登录用户信息到redis(生成token)
        /**
         * Hash
         * Key：login_用户名
         * Value：
         *  Key：token标识
         *  Val：JSON 字符串（用户信息）  防止同一用户多次登录，刷token到redis
         */
        String uuid = UUID.randomUUID().toString();
        //void put(H key, HK hashKey, HV value);
        stringRedisTemplate.opsForHash().put(USER_LOGIN_KEY + requestParam.getUsername(), uuid, JSON.toJSONString(userDO));
        System.out.println(USER_LOGIN_KEY + requestParam.getUsername());
        System.out.println(uuid);
        //设置过期时间
        stringRedisTemplate.expire(USER_LOGIN_KEY + requestParam.getUsername(), 30L, TimeUnit.DAYS);
        return new UserLoginRespDTO(uuid);
    }

    @Override
    public Boolean checkLogin(String username,String token) {
        System.out.println(stringRedisTemplate.opsForHash().get(USER_LOGIN_KEY + username, token));
        return stringRedisTemplate.opsForHash().get(USER_LOGIN_KEY + username, token) != null;
    }

    @Override
    public void logout(String username, String token) {
        //要退出，需要先验证登陆状态
        if(checkLogin(username,token)){
            stringRedisTemplate.delete(USER_LOGIN_KEY+username);
            return;
        }
        throw new ClientException("用户token未存在或用户未登录！");
    }

}
