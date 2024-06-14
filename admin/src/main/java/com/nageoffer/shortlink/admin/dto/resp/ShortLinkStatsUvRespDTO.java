package com.nageoffer.shortlink.admin.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:ShortLinkStatsUvRespDTO
 * Description:
 * 短链接访客监控响应参数
 * @Author DubPAN
 * @Create2024/6/14 14:30
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsUvRespDTO {

    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 访客类型
     */
    private String uvType;

    /**
     * 占比
     */
    private Double ratio;
}