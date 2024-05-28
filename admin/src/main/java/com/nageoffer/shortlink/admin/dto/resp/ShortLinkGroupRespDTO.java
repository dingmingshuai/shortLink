package com.nageoffer.shortlink.admin.dto.resp;

import lombok.Data;

/**
 * ClassName:ShortLinkGroupRespDTO
 * Description:
 * 短链接分组返回实体对象
 * @Author DubPAN
 * @Create2024/5/27 16:30
 * @Version 1.0
 */
@Data
public class ShortLinkGroupRespDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 分组排序
     */
    private Integer sortOrder;

    /**
     * 分组下短链接数量
     */
    private Integer shortLinkCount;
}
