package com.nageoffer.shortlink.admin.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:ShortLinkStatsDeviceRespDTO
 * Description:
 * 短链接访问设备监控响应参数
 * @Author DubPAN
 * @Create2024/6/14 14:25
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsDeviceRespDTO {

    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 设备类型
     */
    private String device;

    /**
     * 占比
     */
    private Double ratio;
}