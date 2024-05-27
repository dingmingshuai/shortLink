package com.nageoffer.shortlink.admin.dto.req;

import ch.qos.logback.core.joran.action.PreconditionValidator;
import lombok.Data;

/**
 * ClassName:ShortLinkGroupSaveReqDTO
 * Description:
 * 创建短链接分组的请求参数
 * @Author DubPAN
 * @Create2024/5/27 15:55
 * @Version 1.0
 */
@Data
public class ShortLinkGroupSaveReqDTO {
    /**
     * 分组名
     */
   private String name;
}
