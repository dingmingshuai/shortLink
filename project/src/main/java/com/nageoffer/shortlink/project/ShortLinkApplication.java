package com.nageoffer.shortlink.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName:ShortLinkAdminApplication
 * Description:
 *
 * @Author DubPAN
 * @Create2024/5/17 20:53
 * @Version 1.0
 */
@MapperScan("com.nageoffer.shortlink.project.dao.mapper")
@SpringBootApplication
public class ShortLinkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortLinkApplication.class,args);
    }
}
