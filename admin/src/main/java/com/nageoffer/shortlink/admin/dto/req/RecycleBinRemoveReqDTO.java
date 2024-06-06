package com.nageoffer.shortlink.admin.dto.req;

import lombok.Data;

/**
 * ClassName:RecycleBinSaveReqDTO
 * Description:
 * 回收站移除功能
 * @Author DubPAN
 * @Create2024/6/5 15:41
 * @Version 1.0
 */
@Data
public class RecycleBinRemoveReqDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 全部短链接
     */
    private String fullShortUrl;
}
