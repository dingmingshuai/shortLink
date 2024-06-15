package com.nageoffer.shortlink.admin.remote.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * ClassName:ShortLinkStatsAccessRecordReqDTO
 * Description:
 * 短链接监控访问记录请求参数
 * @Author DubPAN
 * @Create2024/6/14 16:52
 * @Version 1.0
 */
@Data
public class ShortLinkStatsAccessRecordReqDTO extends Page{

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

    /**
     * 启用标识 0：启用 1：未启用
     */
    private Integer enableStatus;
}
