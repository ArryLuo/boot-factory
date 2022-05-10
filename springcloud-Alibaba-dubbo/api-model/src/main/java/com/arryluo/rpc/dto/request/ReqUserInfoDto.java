package com.arryluo.rpc.dto.request;

import com.arryluo.dto.base.BaseDto;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @ClassName ReqUserInfoDto
 * @Description TODO
 * @Author lzb
 * @Date 2022/5/10 21:06
 * @Version 1.0
 */
@Data
public class ReqUserInfoDto extends BaseDto {
    @NotEmpty(message = "用户名不能为空!")
    private String userName;
    @NotEmpty(message = "密码不能为空!")
    private String password;
}
