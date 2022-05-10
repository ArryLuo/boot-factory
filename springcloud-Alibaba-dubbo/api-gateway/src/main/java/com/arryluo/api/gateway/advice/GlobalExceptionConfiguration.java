package com.arryluo.api.gateway.advice;

import com.arryluo.dto.response.BaseRespDto;
import com.arryluo.enums.ResultCodeEnum;
import com.arryluo.exception.CommonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName GlobalExceptionConfiguration
 * @Description TODO
 * @Author lzb
 * @Date 2022/3/2 17:23
 * @Version 1.0
 */
@Slf4j
@Order(-1)
@RequiredArgsConstructor
@Component
public class GlobalExceptionConfiguration implements ErrorWebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        ServerHttpResponse response = exchange.getResponse();

        if (response.isCommitted()) {
            return Mono.error(ex);
        }

        // header set_json响应
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        //是否响应状态异常
        if (ex instanceof ResponseStatusException) {
            response.setStatusCode(((ResponseStatusException) ex).getStatus());
        }

        return response
                .writeWith(Mono.fromSupplier(() -> {
                    DataBufferFactory bufferFactory = response.bufferFactory();
                    try {
                        //返回json异常原因给前端
                        ObjectMapper objectMapper=new ObjectMapper();
                        BaseRespDto baseResultResponseDto=new BaseRespDto();
                        String code= ResultCodeEnum.FAILED.getCode();
                        try {
                             code = ((CommonException) ex).getCode();
                        }catch (Exception e){
                            log.info("转换异常,全局网关中");
                        }
                        baseResultResponseDto.fail(code,ex.getMessage());
                        return bufferFactory.wrap(objectMapper.writeValueAsBytes(baseResultResponseDto));
                    } catch (JsonProcessingException e) {
                        log.warn("Error writing response", ex);
                        return bufferFactory.wrap(new byte[0]);
                    }
                }));
    }
}
