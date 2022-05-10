package com.arryluo.dto.response;



import com.arryluo.enums.ResultCodeEnum;
import com.arryluo.util.UuidUtil;

import java.io.Serializable;

/**
 * @ClassName BaseResponseDto
 * @Description TODO
 * @Author lzb
 * @Date 2022/2/25 18:02
 * @Version 1.0
 */
public class BaseResponseDto<T> implements Serializable {
    private static final long serialVersionUID = -8114461210248539769L;
    //响应code
    protected String code;
    //响应消息
    protected String message;
    protected String transaction;//交易唯一编码
    protected T data;//业务数据

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * JSON格式
     * 使用AES/DES等对称加密算法加密数据，
     * 密钥为：RKEY-随机密码（请求报文）
     */

    public BaseResponseDto(){

    }
    public BaseResponseDto(String code, String message) {
        this.code = code;
        this.message = message;
        this.transaction = UuidUtil.get32UUID();
    }
    protected BaseResponseDto success() {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.message = ResultCodeEnum.SUCCESS.getMesg();
        this.transaction = UuidUtil.get32UUID();
        return this;
    }
    protected BaseResponseDto fail() {
        this.code = ResultCodeEnum.FAILED.getCode();
        this.message = ResultCodeEnum.FAILED.getMesg();
        this.transaction = UuidUtil.get32UUID();
        return this;
    }
}
