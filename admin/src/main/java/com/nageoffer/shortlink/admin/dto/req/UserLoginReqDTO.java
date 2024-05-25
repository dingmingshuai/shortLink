package com.nageoffer.shortlink.admin.dto.req;

import lombok.Data;

/**
 * ClassName:UserLoginReqDTO
 * Description:
 * 用户登录请求参数
 * @Author DubPAN
 * @Create2024/5/22 20:58
 * @Version 1.0
 */
@Data
public class UserLoginReqDTO {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
