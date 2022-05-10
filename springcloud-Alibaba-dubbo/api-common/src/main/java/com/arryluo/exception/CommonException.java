package com.arryluo.exception;


/**
 * 公共的异常处理
 * Create By lzb
 * 2019/5/14 17:04
 */
public class CommonException extends RuntimeException {
    private String code;

    public CommonException() {
        super();
    }

    public CommonException(String code, String message) {
        super(message);
        this.code = code;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    protected CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
