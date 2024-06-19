package com.nageoffer.shortlink.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName:UserFlowRiskControlConfiguration
 * Description:
 * 用户操作流量风控配置文件
 * @Author DubPAN
 * @Create2024/6/19 14:14
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "short-link.flow-limit")//application.yaml文件对应目录下的参数构成实体配置类（自动读取和绑定配置属性到这个类的字段上）
public class UserFlowRiskControlConfiguration {

    /**
     * 是否开启用户流量风控验证
     */
    private Boolean enable;

    /**
     * 流量风控时间窗口，单位：秒
     */
    private String timeWindow;

    /**
     * 流量风控时间窗口内可访问次数
     */
    private Long maxAccessCount;
}