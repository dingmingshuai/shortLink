package com.nageoffer.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.nageoffer.shortlink.project.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName:TLinkAccessStats
 * Description:
 * 短链接基础访问监控实体
 * @Author DubPAN
 * @Create2024/6/6 22:19
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_link_access_stats")
public class LinkAccessStatsDO extends BaseDO {
    /**
     * id
     */
    private Long id;

    private String gid;

    /**
     * 完整短链接
     */
    private String fullShortUrl;

    /**
     * 日期
     */
    private Date date;

    /**
     * 访问量
     */
    private Integer pv;

    /**
     * 独立访客数
     */
    private Integer uv;

    /**
     * 独立ip数
     */
    private Integer uip;

    /**
     * 小时
     */
    private Integer hour;

    /**
     * 星期
     */
    private Integer weekday;
}
