package com.nageoffer.shortlink.gateway.config;

import lombok.Data;

import java.util.List;

/**
 * ClassName:Config
 * Description:
 * 过滤器配置
 * @Author DubPAN
 * @Create2024/6/21 14:17
 * @Version 1.0
 */
@Data
public class Config {

    /**
     * 白名单前置路径
     */
    private List<String> whitePathList;
}
