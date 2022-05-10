package com.arryluo.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @ClassName HeadDto
 * @Description TODO
 * @Author arryluo
 * @Date 2022/2/25 17:59
 * @Version 1.0
 * head部分
 */
@Data
public class HeadDto implements Serializable {
    private static final long serialVersionUID = -4469284962414363799L;
    @NotEmpty(
            message = "{time不能为空}"
    )
    private String time;
    @NotEmpty(
            message = "{rkey不能为空}"
    )
    private String rkey;
    @NotEmpty(
            message = "{method不能为空}"
    )
    private String method;
    @NotEmpty(
            message = "{token不能为空}"
    )
    private String token;
}
