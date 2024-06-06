package com.nageoffer.shortlink.project.dto.req;

import lombok.Data;

/**
 * ClassName:RecycleBinSaveReqDTO
 * Description:
 * 回收站恢复功能
 * @Author DubPAN
 * @Create2024/6/5 15:41
 * @Version 1.0
 */
@Data
public class RecycleBinRecoverReqDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 全部短链接
     */
    private String fullShortUrl;
}
