package com.nageoffer.shortlink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nageoffer.shortlink.project.dao.entity.LinkAccessStatsDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName:LinkAccessStatsMapper
 * Description:
 * 短链接基础访问持久层
 * @Author DubPAN
 * @Create2024/6/6 22:34
 * @Version 1.0
 */
public interface LinkAccessStatsMapper extends BaseMapper <LinkAccessStatsDO> {
    /**
     * 记录基础访问监控数据
     * @param linkAccessStatsDO
     */

    @Insert("INSERT INTO t_link_access_stats (full_short_url, gid,date, pv, uv, uip, hour, weekday, create_time, update_time, del_flag) " +
            "VALUES( #{linkAccessStats.fullShortUrl},#{linkAccessStats.gid}, #{linkAccessStats.date}, #{linkAccessStats.pv}, #{linkAccessStats.uv}," +
            " #{linkAccessStats.uip}, #{linkAccessStats.hour}, #{linkAccessStats.weekday}, NOW(), NOW(), 0) " +
            "ON DUPLICATE KEY UPDATE pv = pv +  #{linkAccessStats.pv}, uv = uv + #{linkAccessStats.uv}, uip = uip + #{linkAccessStats.uip};")
    void shortLinkStats(@Param("linkAccessStats") LinkAccessStatsDO linkAccessStatsDO);
}
