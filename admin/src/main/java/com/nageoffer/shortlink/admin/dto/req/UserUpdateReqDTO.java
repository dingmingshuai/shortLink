package com.nageoffer.shortlink.admin.dto.req;

import lombok.Data;

/**
 * ClassName:UserUpdateReqDTO
 * Description:
 * 用户更改信息求情参数
 * @Author DubPAN
 * @Create2024/5/22 20:11
 * @Version 1.0
 */
@Data
public class UserUpdateReqDTO {
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
