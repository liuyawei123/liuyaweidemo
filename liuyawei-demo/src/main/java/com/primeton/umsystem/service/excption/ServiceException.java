package com.primeton.umsystem.service.excption;

import org.springframework.http.HttpStatus;

/**
 *其他异常的父异常
 * @author liuya
 *
 */
public class ServiceException 
	extends RuntimeException {

	private static final long serialVersionUID = -2879099986352308425L;
	
	
	public ServiceException(String infomation, Integer num) {
		super();
		this.infomation = infomation;
		this.num = num;
	}
	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	private String infomation;
	private Integer num;

	public ServiceException(HttpStatus httpStatus, String infomation) {
		super();
		this.httpStatus = httpStatus;
		this.infomation = infomation;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getInfomation() {
		return infomation;
	}

	public void setInfomation(String infomation) {
		this.infomation = infomation;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
