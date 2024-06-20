package com.nageoffer.shortlink.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName:ShortLinkAdminApplication
 * Description:
 *
 * @Author DubPAN
 * @Create2024/5/17 20:53
 * @Version 1.0
 */
@MapperScan("com.nageoffer.shortlink.admin.dao.mapper")
@EnableDiscoveryClient
@EnableFeignClients("com.nageoffer.shortlink.admin.remote")//openFeign扫描路径
@SpringBootApplication
public class ShortLinkAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortLinkAdminApplication.class,args);
    }
}
