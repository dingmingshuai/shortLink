package com.nageoffer.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.admin.dao.entity.GroupDO;
import com.nageoffer.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.nageoffer.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;

import java.util.List;

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

    /**
     * 查询用户短链接分组集合
     *
     * @return 用户短链接分组集合
     */
    List<ShortLinkGroupRespDTO> listGroup();

    /**
     * 修改用户短链接分组名称
     * @param requstParam 修改用户短链接分组参数
     */
    void updateGroup(ShortLinkGroupUpdateReqDTO requstParam);
}
