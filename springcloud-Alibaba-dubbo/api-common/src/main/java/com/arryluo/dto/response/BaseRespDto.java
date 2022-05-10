package com.arryluo.dto.response;


import com.arryluo.enums.ResultCodeEnum;
import com.arryluo.util.UuidUtil;

/**
 * @ClassName BaseResultDto
 * @Description TODO
 * @Author arryluo
 * @Version 1.0
 */

public class BaseRespDto<T> extends BaseResponseDto<T>{
    private static final long serialVersionUID = -471909791996245327L;
    public BaseRespDto(){

    }

    public BaseRespDto(String code, String message){
        super(code,message);
    }
    public BaseRespDto success() {
        super.success();
        return this;
    }
   /* *//**
     * 新增是否成功方法
     * @return
     *//*
    public boolean isSuccess(){
        boolean flag=true;
        if (!StringUtils.equals(ResultCodeEnum.SUCCESS.getCode(), this.getCode())) {
            flag=false;
        }
        return flag;
    }*/
    public BaseRespDto success(String message) {
        this.message = message;
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.transaction = UuidUtil.get32UUID();
        return this;
    }
    public BaseRespDto success(String code, String message) {
        this.message = message;
        this.code = code;
        this.transaction = UuidUtil.get32UUID();
        return this;
    }
    public BaseRespDto fail(String err_code, String err_code_des) {
        this.code =err_code;
        this.message = err_code_des;
        this.transaction = UuidUtil.get32UUID();
        return this;
    }
    public BaseRespDto fail(String err_code_des) {
        this.code =ResultCodeEnum.SUCCESS.getCode();;
        this.message = err_code_des;
        this.transaction = UuidUtil.get32UUID();
        return this;
    }
    public BaseRespDto fail() {
        super.fail();
        return this;
    }

}
