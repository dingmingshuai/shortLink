package com.nageoffer.shortlink.project.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
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
public class ShortLinkPageReqDTO extends Page<ShortLinkDO> {

    /**
     * 分组标识
     */
    private String gid;

//    /**
//     * 排序标识
//     */
//    private String orderTag;
}
