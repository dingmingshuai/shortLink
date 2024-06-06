package com.nageoffer.shortlink.project.dto.req;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
import lombok.Data;

import java.util.List;

/**
 * ClassName:ShortLinkPageReqDTO
 * Description:
 * 回收站分短链接页请求参数
 * @Author DubPAN
 * @Create2024/5/31 15:24
 * @Version 1.0
 */
@Data
public class ShortLinkRecycleBinPageReqDTO extends Page<ShortLinkDO> {

    /**
     * 分组标识
     */
    private List<String> gidList;

}
