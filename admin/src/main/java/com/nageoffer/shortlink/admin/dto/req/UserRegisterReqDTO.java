package com.nageoffer.shortlink.admin.dto.req;

import lombok.Data;

/**
 * ClassName:UserRegisterReqDTO
 * Description:
 *  用户注册请求参数
 * @Author DubPAN
 * @Create2024/5/20 19:25
 * @Version 1.0
 */
@Data
public class UserRegisterReqDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;
}