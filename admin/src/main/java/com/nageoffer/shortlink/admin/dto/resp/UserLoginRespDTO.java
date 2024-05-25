package com.nageoffer.shortlink.admin.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:UserLoginRespDTO
 * Description:
 * 用户登录接口返回响应参数
 * @Author DubPAN
 * @Create2024/5/22 20:47
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRespDTO {
    /**
     * 用户Token
     */
    private String token;
}
