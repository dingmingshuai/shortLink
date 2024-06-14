package com.nageoffer.shortlink.admin.controller;

import com.nageoffer.shortlink.admin.common.convention.result.Result;
import com.nageoffer.shortlink.admin.common.convention.result.Results;
import com.nageoffer.shortlink.admin.dto.req.ShortLinkStatsReqDTO;
import com.nageoffer.shortlink.admin.dto.resp.ShortLinkStatsRespDTO;
import com.nageoffer.shortlink.admin.remote.ShortLinkRemoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:ShortLinkStatsController
 * Description:
 *
 * @Author DubPAN
 * @Create2024/6/14 15:52
 * @Version 1.0
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkStatsController {
    //TODO 后续重构为SpringCloud Feign 调用
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    /**
     * 访问单个短链接指定时间内监控数据
     */
    /**
     * 访问单个短链接指定时间内监控数据
     */
    @GetMapping("/api/short-link/admin/v1/stats")
    public Result<ShortLinkStatsRespDTO> shortLinkStats(ShortLinkStatsReqDTO requestParam) {
        return shortLinkRemoteService.oneShortLinkStats(requestParam);
    }
}
