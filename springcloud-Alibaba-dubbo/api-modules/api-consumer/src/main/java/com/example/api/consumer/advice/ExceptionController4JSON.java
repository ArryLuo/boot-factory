package com.example.api.consumer.advice;



import com.arryluo.dto.response.BaseRespDto;
import com.arryluo.enums.ResultCodeEnum;
import com.arryluo.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;

@ControllerAdvice
@Slf4j
public class ExceptionController4JSON {

	@Autowired
	private MessageSource messageSource;
	/**
	 * 处理绑定参数异常，表单提交参数验证异常等
	 * @param e
	 * @return JSON格式的响应信息
	 */
	@ResponseBody
	@ExceptionHandler({ BindException.class})
	public BaseRespDto exception(BindException e) {
		log.error(e.getMessage(),e);
		List<ObjectError> allErrors = e.getAllErrors();
        return getErr(allErrors);
	}
	@ResponseBody
	@ExceptionHandler({ MethodArgumentNotValidException.class})
	public BaseRespDto exception(MethodArgumentNotValidException e) {
		log.error(e.getMessage(),e);
		List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
		return getErr(allErrors);
	}

	private BaseRespDto getErr(List<ObjectError> allErrors){
        for (ObjectError error : allErrors) {
            String errorCode = error.getDefaultMessage();
            return new BaseRespDto().fail(errorCode,i18n(errorCode));
        }
        String msg =i18n("MSG_ERROR_OTHER");
        return new BaseRespDto().fail("MSG_ERROR_OTHER",msg);
    }
	@ResponseBody
	@ExceptionHandler({ CommonException.class})
	public BaseRespDto exception(CommonException e) {
		log.error(e.getMessage(),e);
		return new BaseRespDto().fail(e.getCode(),e.getMessage());
	}








	@ResponseBody
	@ExceptionHandler({ Exception.class })
	public BaseRespDto exception(Exception e) {
		log.error(e.getMessage(),e);
		return new BaseRespDto().fail(ResultCodeEnum.FAILED.getCode(),"系统异常");
	}
	@ResponseBody
	@ExceptionHandler({ RuntimeException.class })
	public BaseRespDto exception(RuntimeException e) {
		log.error(e.getMessage(),e);
		return new BaseRespDto().fail(ResultCodeEnum.FAILED.getCode(),"系统异常");
	}




	public String i18n(String code){
		return messageSource.getMessage(code, null, Locale.getDefault());
	}

}
