package com.nageoffer.shortlink.project.controller;

import com.nageoffer.shortlink.project.common.convention.result.Result;
import com.nageoffer.shortlink.project.common.convention.result.Results;
import com.nageoffer.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.nageoffer.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.nageoffer.shortlink.project.service.ShortLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:ShortLinkController
 * Description:
 * 短链接控制层
 * @Author DubPAN
 * @Create2024/5/28 17:15
 * @Version 1.0
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkController {
    private final ShortLinkService shortLinkService;//配合@RequiredArgsConstructor，实现构造器注入
    /**
     * 创建短链接
     * @return
     */
    @PostMapping("/api/short-link/v1/create")
    public Result createShortLink(@RequestBody ShortLinkCreateReqDTO resquestParam){
        return Results.success(shortLinkService.createShortLink(resquestParam));
    }
}
