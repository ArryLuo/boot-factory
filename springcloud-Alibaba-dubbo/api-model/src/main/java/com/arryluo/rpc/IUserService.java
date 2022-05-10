package com.arryluo.rpc;

import com.arryluo.dto.request.BaseReqDto;
import com.arryluo.dto.response.BaseRespDto;
import com.arryluo.rpc.dto.request.ReqUserInfoDto;
import com.arryluo.rpc.dto.response.ResUserInfoDto;

/**
 * @ClassName IUserService
 * @Description TODO
 * @Author arryluo
 * @Date 2022/5/10 21:05
 * @Version 1.0
 */
public interface IUserService {
    BaseRespDto<ResUserInfoDto> login(BaseReqDto<ReqUserInfoDto> reqUserInfoDtoBaseReqDto);
}
