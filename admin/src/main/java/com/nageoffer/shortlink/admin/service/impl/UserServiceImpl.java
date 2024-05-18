package com.nageoffer.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nageoffer.shortlink.admin.dao.entity.UserDO;
import com.nageoffer.shortlink.admin.dao.mapper.UserMapper;
import com.nageoffer.shortlink.admin.dto.resp.UserRespDTO;
import com.nageoffer.shortlink.admin.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

/**
 * ClassName:UserServiceImpl
 * Description:
 * 用户接口实现层
 * @Author DubPAN
 * @Create2024/5/18 16:17
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Override
    public UserRespDTO getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        UserRespDTO result = new UserRespDTO();
        BeanUtils.copyProperties(userDO,result);
        return result;
    }
}
