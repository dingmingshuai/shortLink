package com.nageoffer.shortlink.project.service;

import com.nageoffer.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.nageoffer.shortlink.project.dto.resp.ShortLinkStatsRespDTO;

/**
 * ClassName:ShortLinkStatsService
 * Description:
 * 短链接监控接口层
 * @Author DubPAN
 * @Create2024/6/13 16:51
 * @Version 1.0
 */
/**
 * 短链接监控接口层
 */
public interface ShortLinkStatsService {

    /**
     * 获取单个短链接监控数据
     *
     * @param requestParam 获取短链接监控数据入参
     * @return 短链接监控数据
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);
}
