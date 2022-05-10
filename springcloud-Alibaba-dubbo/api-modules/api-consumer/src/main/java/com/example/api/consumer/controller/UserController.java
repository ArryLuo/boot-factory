package com.example.api.consumer.controller;

import com.arryluo.dto.request.BaseReqDto;
import com.arryluo.dto.response.BaseRespDto;
import com.arryluo.rpc.IUserService;
import com.arryluo.rpc.dto.request.ReqUserInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author arryluo
 * @Date 2022/5/10 22:09
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
    @DubboReference
    private IUserService iUserService;
    @RequestMapping("login")
    public BaseRespDto login(@RequestBody @Valid BaseReqDto<ReqUserInfoDto> reqUserInfoDtoBaseReqDto){
        log.info("##########消费者入口");
        return iUserService.login(reqUserInfoDtoBaseReqDto);
    }
}
