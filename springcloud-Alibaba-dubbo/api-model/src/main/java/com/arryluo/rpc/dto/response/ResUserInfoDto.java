package com.arryluo.rpc.dto.response;

import com.arryluo.dto.base.BaseDto;
import lombok.Data;

/**
 * @ClassName ResUserInfo
 * @Description TODO
 * @Author lzb
 * @Date 2022/5/10 21:20
 * @Version 1.0
 */
@Data
public class ResUserInfoDto extends BaseDto {
    private String name;
    private int age;

}
