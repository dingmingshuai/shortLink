package com.nageoffer.shortlink.admin.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:ShortLinkStatsBrowserRespDTO
 * Description:
 * 短链接浏览器监控响应参数
 * @Author DubPAN
 * @Create2024/6/14 14:24
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsBrowserRespDTO {

    /**
     * 统计
     */
    private Integer cnt;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 占比
     */
    private Double ratio;
}