package com.nageoffer.shortlink.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName:ShortLinkAdminApplication
 * Description:
 *
 * @Author DubPAN
 * @Create2024/5/17 20:53
 * @Version 1.0
 */
@EnableDiscoveryClient//启动类声明引用注册中心
@MapperScan("com.nageoffer.shortlink.project.dao.mapper")
@SpringBootApplication
public class ShortLinkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortLinkApplication.class,args);
    }
}
