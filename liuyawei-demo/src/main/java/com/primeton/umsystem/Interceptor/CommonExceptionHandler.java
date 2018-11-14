package com.primeton.umsystem.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.primeton.umsystem.entity.ResponseResult;
import com.primeton.umsystem.service.excption.ServiceException;

/**
 * 异常拦截器
 * 实现自定义异常与常见异常的统一拦截处理
 * @author liuyawei
 *
 */
@RestControllerAdvice
public class CommonExceptionHandler{
	/**
	 * 日志记录器
	 */
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
	
	//捕捉到的异常
    @ExceptionHandler(value = ServiceException.class)
    public ResponseResult<Void> handleServiceException(ServiceException e)
    {
    	
			logger.error("很遗憾您出现了"+e.getMessage()+"请及时处理");
			System.out.println("拦截器自定义异常处理完毕");
			return new ResponseResult<Void>(e.getNum(),e.getInfomation());
		
    }
    /**
     * ResponseStatus注解是修饰类的它有两个属性，value属性是http状态码，比如404，500等。reason是错误信息
     * @param e
     * @return
     */
    //其他异常
    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,reason="代码出现错误")
    public void handleServerException(Exception e)
    {
    	logger.error("很遗憾您出现了"+e.getMessage()+"请及时处理");
        
    }
	
}

