package com.nageoffer.shortlink.admin.controller;


import com.nageoffer.shortlink.admin.common.convention.result.Result;
import com.nageoffer.shortlink.admin.remote.ShortLinkActualRemoteService;
import com.nageoffer.shortlink.admin.remote.ShortLinkRemoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:UrlTitleController
 * Description:
 * URL标题控制层
 * @Author DubPAN
 * @Create2024/6/4 20:48
 * @Version 1.0
 */
@RestController
@RequiredArgsConstructor
public class UrlTitleController {

    //重构为SpringCloud Feign 调用
    private final ShortLinkActualRemoteService shortLinkActualRemoteService;

    /**
     * 根据 URL 获取对应网站的标题
     */
    @GetMapping("/api/short-link/admin/v1/title")
    public Result<String> getTitleByUrl(@RequestParam("url") String url) {
        return shortLinkActualRemoteService.getTitleByUrl(url);
    }
}
