package com.nageoffer.shortlink.admin.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nageoffer.shortlink.admin.dao.entity.GroupDO;
import com.nageoffer.shortlink.admin.dao.mapper.GroupMapper;
import com.nageoffer.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.nageoffer.shortlink.admin.service.GroupService;
import com.nageoffer.shortlink.admin.toolkit.RandomGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .gid(gid)
                .sortOrder(0)//默认排序0
                .name(groupName)
                .build();//GroupDO添加了@Builder注解，可以使用链式建造
        baseMapper.insert(groupDO);
    }

    @Override
    public List<ShortLinkGroupRespDTO> listGroup() {
        //TODO 从当前上下文获取用户名
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getDelFlag, 0)//确保是生效中的短链接分组
                .eq(GroupDO::getUsername, null)
                .orderByDesc(List.of(GroupDO::getSortOrder, GroupDO::getUpdateTime));//先按SortOrder字段排序，再按更新时间排序
        List<GroupDO> groupDOList = baseMapper.selectList(queryWrapper);
        return BeanUtil.copyToList(groupDOList, ShortLinkGroupRespDTO.class);
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
