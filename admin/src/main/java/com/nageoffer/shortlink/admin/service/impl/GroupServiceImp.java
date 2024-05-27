package com.nageoffer.shortlink.admin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nageoffer.shortlink.admin.dao.entity.GroupDO;
import com.nageoffer.shortlink.admin.dao.mapper.GroupMapper;
import com.nageoffer.shortlink.admin.service.GroupService;
import com.nageoffer.shortlink.admin.toolkit.RandomGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ClassName:GroupServiceImp
 * Description:
 * 短链接分组接口实现层
 * @Author DubPAN
 * @Create2024/5/27 15:17
 * @Version 1.0
 */
@Service
@Slf4j
public class GroupServiceImp extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {
    @Override
    public void saveGroup(String groupName) {
        String gid;
        while(true){
             gid = RandomGenerator.generateRandom();
             if (NohasGid(gid)){//当前未创建该分组id
                 break;//跳出
             }
        }
        //创建并保存该分组id
        GroupDO groupDO =GroupDO.builder()
                .gid(RandomGenerator.generateRandom())
                .name(groupName)
                .build();//GroupDO添加了@Builder注解，可以使用链式建造
        baseMapper.insert(groupDO);
    }
    private boolean NohasGid(String gid){
        //保证当前短链接分组id唯一
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getGid,gid)
                //TODO 设置用户名
                .eq(GroupDO::getUsername, null);
        GroupDO NohasGroupFlag = baseMapper.selectOne(queryWrapper);
        return NohasGroupFlag == null;//返回true，则当前未创建该分组id
    }
}
