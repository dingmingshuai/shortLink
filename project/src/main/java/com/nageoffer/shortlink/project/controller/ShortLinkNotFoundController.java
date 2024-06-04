package com.nageoffer.shortlink.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:ShortLinkNotFoundController
 * Description:
 * 短链接不存在跳转控制器
 * @Author DubPAN
 * @Create2024/6/4 20:28
 * @Version 1.0
 */
@Controller//@Controller可以返回视图，而@RestController 返回的是JSON字符串
public class ShortLinkNotFoundController {
    /**
     * 短链接不存在跳转页面
     */
    @RequestMapping("/page/notfound")
    public String notfound() {
        return "notfound";
    }
}
