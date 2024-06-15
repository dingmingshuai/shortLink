package com.nageoffer.shortlink.admin.remote.dto.req;

import lombok.Data;

/**
 * ClassName:ShortLinkStatsReqDTO
 * Description:
 * 短链接监控请求参数
 * @Author DubPAN
 * @Create2024/6/13 16:57
 * @Version 1.0
 */
@Data
public class ShortLinkStatsReqDTO {
    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;

}
