package com.nageoffer.shortlink.admin.common.convention.exception;

import com.nageoffer.shortlink.admin.common.convention.errorcode.IErrorCode;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * ClassName:AbstractException
 * Description:
 抽象项目中三类异常体系，客户端异常、服务端异常以及远程服务调用异常
 *
 * @see ClientException
 * @see ServiceException
 * @see RemoteException
 * @Author DubPAN
 * @Create2024/5/19 16:13
 * @Version 1.0
 */
public abstract class AbstractException extends RuntimeException {

    public final String errorCode;

    public final String errorMessage;

    public AbstractException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable);
        this.errorCode = errorCode.code();
        this.errorMessage = Optional.ofNullable(StringUtils.hasLength(message) ? message : null).orElse(errorCode.message());
    }
}