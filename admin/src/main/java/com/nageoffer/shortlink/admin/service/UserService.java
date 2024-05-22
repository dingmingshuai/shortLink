package com.nageoffer.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nageoffer.shortlink.admin.dao.entity.UserDO;
import com.nageoffer.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.nageoffer.shortlink.admin.dto.resp.UserRespDTO;

/**
 * ClassName:UserService
 * Description:
 * 用户接口层
 * @Author DubPAN
 * @Create2024/5/18 16:12
 * @Version 1.0
 */
public interface UserService extends IService <UserDO> {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 用户实体
     */
    UserRespDTO getUserByUsername (String username);

    /**
     * 查询用户名是否存在
     * @param username 用户名
     * @return 用户存在返回 True
     */
    Boolean hasUsername(String username);

    /**
     * 注册用户
     *
     * @param requestParam 注册用户请求参数
     */
    void register(UserRegisterReqDTO requestParam);
}
