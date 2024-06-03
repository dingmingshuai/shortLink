package com.nageoffer.shortlink.project.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * ClassName:VailDateTypeEnum
 * Description:
 * 效期类型
 * @Author DubPAN
 * @Create2024/6/3 16:58
 * @Version 1.0
 */
@RequiredArgsConstructor
public enum VailDateTypeEnum {

    /**
     * 永久有效期
     */
    PERMANENT(0),

    /**
     * 自定义有效期
     */
    CUSTOM(1);

    @Getter
    private final int type;
}
