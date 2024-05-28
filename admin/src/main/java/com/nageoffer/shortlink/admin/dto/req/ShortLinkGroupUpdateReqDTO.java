package com.nageoffer.shortlink.admin.dto.req;

import lombok.Data;

/**
 * ClassName:ShortLinkGroupSaveReqDTO
 * Description:
 * 修改短链接分组的请求参数
 * @Author DubPAN
 * @Create2024/5/27 15:55
 * @Version 1.0
 */
@Data
public class ShortLinkGroupUpdateReqDTO {
    /**
     * 分组标识
     */
    private String gid;
    /**
     * 分组名
     */
   private String name;
}
