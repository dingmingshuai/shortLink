package com.nageoffer.shortlink.admin.common.biz.user;

/**
 * ClassName:UserInfoDTO
 * Description:
 * 用户信息实体
 * @Author DubPAN
 * @Create2024/5/27 16:54
 * @Version 1.0
 */

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoDTO {

    /**
     * 用户 ID
     */
    @JSONField(name = "id")
    private String userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;


}
