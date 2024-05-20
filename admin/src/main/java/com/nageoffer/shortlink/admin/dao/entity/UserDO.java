package com.nageoffer.shortlink.admin.dao.entity;

/**
 * ClassName:UserDO
 * Description:
 *
 * @Author DubPAN
 * @Create2024/5/18 15:04
 * @Version 1.0
 */


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户持久层实体
 */
@Data
@TableName("t_user")
public class UserDO  {

    /**
     * id
     */
    private Long id;

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

    /**
     * 注销时间戳
     */
    private Long deletionTime;

    /**
     * 生成时间
     */
    @TableField(fill = FieldFill.INSERT)//mybatisPlus的MetaObjectHandler接口自动注入
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)//mybatisPlus的MetaObjectHandler接口自动注入
    private LocalDateTime updateTime;

    /**
     * 逻辑删除 0:未删除 1:已删除
     */
    @TableField(fill = FieldFill.INSERT)//mybatisPlus的MetaObjectHandler接口自动注入
    private Integer delFlag;
}
