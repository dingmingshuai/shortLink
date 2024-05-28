package com.nageoffer.shortlink.admin.dto.req;

import lombok.Data;

/**
 * ClassName:ShortLinkGroupSaveReqDTO
 * Description:
 * 短链接分组排序的请求参数
 * @Author DubPAN
 * @Create2024/5/27 15:55
 * @Version 1.0
 */
@Data
public class ShortLinkGroupSortReqDTO {
    /**
     * 分组ID
     */
   private String gid;
    /**
     * 排序序列号
     */
   private Integer sortOrder;
}
