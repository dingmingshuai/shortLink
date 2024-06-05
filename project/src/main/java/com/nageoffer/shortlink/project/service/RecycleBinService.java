package com.nageoffer.shortlink.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
import com.nageoffer.shortlink.project.dto.req.RecycleBinSaveReqDTO;

/**
 * ClassName:RecycleBinService
 * Description:
 * 回收站管理接口层
 * @Author DubPAN
 * @Create2024/6/5 16:14
 * @Version 1.0
 */
public interface RecycleBinService extends IService <ShortLinkDO> {
    /**
     * 保存回收站
     * @param requestParam 请求参数
     */
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);
}
