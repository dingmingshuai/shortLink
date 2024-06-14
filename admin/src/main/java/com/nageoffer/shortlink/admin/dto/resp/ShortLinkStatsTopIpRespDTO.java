package com.nageoffer.shortlink.admin.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:ShortLinkStatsTopIpRespDTO
 * Description:
 * 短链接高频访问IP监控响应参数
 * @Author DubPAN
 * @Create2024/6/14 14:29
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsTopIpRespDTO {

    /**
     * 统计
     */
    private Integer cnt;

    /**
     * IP
     */
    private String ip;
}