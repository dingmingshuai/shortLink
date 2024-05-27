package com.nageoffer.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.admin.dao.entity.GroupDO;

/**
 * ClassName:GroupService
 * Description:
 * 短链接分组接口层
 * @Author DubPAN
 * @Create2024/5/27 14:58
 * @Version 1.0
 */
public interface GroupService extends IService <GroupDO>{
    /**
     * 新增短链接分组
     * @param groupName 短链接分组名
     */
    void saveGroup(String groupName);
}
