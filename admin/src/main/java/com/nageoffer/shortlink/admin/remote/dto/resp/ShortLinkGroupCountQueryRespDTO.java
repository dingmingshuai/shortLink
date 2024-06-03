package com.nageoffer.shortlink.admin.remote.dto.resp;

import lombok.Data;

/**
 * ClassName:ShortLinkCountQueryReqDTO
 * Description:
 * 短链接分组查询返回参数
 * @Author DubPAN
 * @Create2024/6/3 11:11
 * @Version 1.0
 */
@Data
public class ShortLinkGroupCountQueryRespDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 短链接数量
     */
    private Integer shortLinkCount;
}
