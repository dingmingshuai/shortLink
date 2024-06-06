package com.nageoffer.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nageoffer.shortlink.project.common.convention.result.Result;
import com.nageoffer.shortlink.project.common.convention.result.Results;
import com.nageoffer.shortlink.project.dto.req.RecycleBinRecoverReqDTO;
import com.nageoffer.shortlink.project.dto.req.RecycleBinSaveReqDTO;
import com.nageoffer.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.nageoffer.shortlink.project.dto.req.ShortLinkRecycleBinPageReqDTO;
import com.nageoffer.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import com.nageoffer.shortlink.project.service.RecycleBinService;
import lombok.RequiredArgsConstructor;
import org.apache.curator.retry.RetryUntilElapsed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:RecycleBInController
 * Description:
 * 回收站管理控制层
 * @Author DubPAN
 * @Create2024/6/5 15:25
 * @Version 1.0
 */
@RestController
@RequiredArgsConstructor
public class RecycleBinController {
    private final RecycleBinService recycleBinService;

    /**
     * 保存回收站
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam){
        recycleBinService.saveRecycleBin(requestParam);
        return Results.success();
    }

    /**
     * 分页查询回收站里的短链接
     * @param requestParam
     * @return
     */
    @GetMapping("/api/short-link/v1/recycle-bin/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkRecycleBinPageReqDTO  requestParam){
        return Results.success(recycleBinService.pageShortLink(requestParam));
    }

    /**
     * 恢复短链接
     * @param requestParam  恢复短链接请求参数
     * @return
     */
    @PostMapping("/api/short-link/v1/recycle-bin/recover")
    public Result<Void>  recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam){
        recycleBinService.recoverRecycleBin(requestParam);
        return Results.success();
    }
}
