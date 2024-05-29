package com.nageoffer.shortlink.project.common.database;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName:BaseDo
 * Description:
 * 数据表基本字段
 * 生成时间、修改时间、删除
 * @Author DubPAN
 * @Create2024/5/27 16:01
 * @Version 1.0
 */
@Data
public class BaseDO {
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
