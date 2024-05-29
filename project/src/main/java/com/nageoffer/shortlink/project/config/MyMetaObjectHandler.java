package com.nageoffer.shortlink.project.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * ClassName:MyMetaObjectHandler
 * Description:
 * MetaObjectHandler接口是mybatisPlus为我们提供的的一个扩展接口，
 * 我们可以利用这个接口在我们插入或者更新数据的时候，为一些字段指定默认值.
 * 填充创建/修改时间
 * @Author DubPAN
 * @Create2024/5/20 20:19
 * @Version 1.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
        strictInsertFill(metaObject, "updateTime", LocalDateTime::now,LocalDateTime.class);
        strictInsertFill(metaObject, "delFlag", () -> 0, Integer.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        strictInsertFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }
}
