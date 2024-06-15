package com.nageoffer.shortlink.project.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nageoffer.shortlink.project.dao.entity.LinkAccessLogsDO;
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
public class ShortLinkStatsAccessRecordReqDTO extends Page<LinkAccessLogsDO> {
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
