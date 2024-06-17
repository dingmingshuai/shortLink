package com.nageoffer.shortlink.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nageoffer.shortlink.project.dao.entity.LinkStatsTodayDO;
import com.nageoffer.shortlink.project.dao.mapper.LinkStatsTodayMapper;
import com.nageoffer.shortlink.project.service.LinkStatsTodayService;
import org.springframework.stereotype.Service;

/**
 * ClassName:LinkStatsTodayServiceImpl
 * Description:
 * 短链接今日统计接口实现层
 * @Author DubPAN
 * @Create2024/6/17 20:36
 * @Version 1.0
 */
@Service
public class LinkStatsTodayServiceImpl extends ServiceImpl<LinkStatsTodayMapper, LinkStatsTodayDO> implements LinkStatsTodayService {
}