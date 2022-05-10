package com.arryluo.enums;



/**
 * Create By arryluo
 * 2019/9/17 11:44
 */
public enum ResultCodeEnum {
    SUCCESS("200","响应成功"),
    FIELD_MISSING("400","字段缺失"),
    HEAD_DECRYPTION_FAILED ("401","HEAD解密失败"),
    FAILED("999999","失败"),


    ;

    private String code;
    private String mesg;

    ResultCodeEnum(String code, String mesg){
        this.code = code;
        this.mesg = mesg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }


}
