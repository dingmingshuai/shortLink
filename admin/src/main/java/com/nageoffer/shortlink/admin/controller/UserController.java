package com.nageoffer.shortlink.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:UserController
 * Description:
 * 用户管理控制层
 * @Author DubPAN
 * @Create2024/5/18 14:26
 * @Version 1.0
 */
@RestController
public class UserController {
    /**
     *根据用户明查询用户
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public String ggetUserByUsername(@PathVariable("username") String username){
        return "Hi "+username;
    }
}
