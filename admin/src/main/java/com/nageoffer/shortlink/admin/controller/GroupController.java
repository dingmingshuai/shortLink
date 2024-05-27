package com.nageoffer.shortlink.admin.controller;

import com.nageoffer.shortlink.admin.service.GroupService;
import com.nageoffer.shortlink.admin.service.impl.GroupServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:GroupController
 * Description:
 * 短链接分组控制层
 * @Author DubPAN
 * @Create2024/5/27 15:20
 * @Version 1.0
 */
@RestController
@RequiredArgsConstructor //构造方法注入
public class GroupController {
    private final GroupService groupService;//配合@RequiredArgsConstructor，实现构造方法注入GroupService类对象属性
}
