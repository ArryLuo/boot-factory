package com.arryluo.api.provider.service.impl;

import com.arryluo.dto.request.BaseReqDto;
import com.arryluo.dto.response.BaseRespDto;
import com.arryluo.rpc.IUserService;
import com.arryluo.rpc.dto.request.ReqUserInfoDto;
import com.arryluo.rpc.dto.response.ResUserInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author arryluo
 * @Date 2022/5/10 21:49
 * @Version 1.0
 */
@DubboService
@Slf4j
public class UserServiceImpl implements IUserService {
    @Override
    public BaseRespDto<ResUserInfoDto> login(BaseReqDto<ReqUserInfoDto> reqUserInfoDtoBaseReqDto) {
        log.info("########用户登录请求参数,{}",reqUserInfoDtoBaseReqDto.getData());
        ReqUserInfoDto reqUserInfoDto= reqUserInfoDtoBaseReqDto.getData();
        BaseRespDto<ResUserInfoDto> baseRespDto=new BaseRespDto<ResUserInfoDto>();
        if(!StringUtils.equals("arryluo",reqUserInfoDto.getUserName())){
            baseRespDto.fail("账户密码错误");
            return baseRespDto;
        }
        ResUserInfoDto userInfoDto=new ResUserInfoDto();
        userInfoDto.setAge(18);
        userInfoDto.setName("arryluo");
        baseRespDto.setData(userInfoDto);
        return baseRespDto.success();
    }
}
