package com.nageoffer.shortlink.admin.remote.dto.req;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * ClassName:ShortLinkPageReqDTO
 * Description:
 * 短链接分页请求参数
 * @Author DubPAN
 * @Create2024/5/31 15:24
 * @Version 1.0
 */
@Data
public class ShortLinkPageReqDTO extends Page {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 排序标识
     */
    private String orderTag;
}
