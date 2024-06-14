package com.nageoffer.shortlink.admin.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:ShortLinkStatsNetworkRespDTO
 * Description:
 * 短链接访问网络监控响应参数
 * @Author DubPAN
 * @Create2024/6/14 14:26
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsNetworkRespDTO {

    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 访问网络
     */
    private String network;

    /**
     * 占比
     */
    private Double ratio;
}