package com.arryluo.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @ClassName BaeReqDto
 * @Description TODO
 * @Author arryluo
 * @Date 2022/2/25 17:17
 * @Version 1.0
 * 基础的请求封装
 */
@Data
public class BaseReqDto<T> extends BaseDto {
    private static final long serialVersionUID = -4469284962414363794L;
    @NotEmpty(
            message = "{appId不能为空}"
    )
    private String appId;
    @NotNull(
            message = "{head不能为空}"
    )
    private HeadDto head;
    @NotNull(
            message = "{data不能为空}"
    )
    private T data;//数据集

}
