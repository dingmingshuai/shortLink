package com.nageoffer.shortlink.admin.remote.dto.req;

import lombok.Data;

/**
 * ClassName:ShortLinkGroupStatsReqDTO
 * Description:
 * 分组短链接监控请求参数
 * @Author DubPAN
 * @Create2024/6/16 14:52
 * @Version 1.0
 */
@Data
public class ShortLinkGroupStatsReqDTO {

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