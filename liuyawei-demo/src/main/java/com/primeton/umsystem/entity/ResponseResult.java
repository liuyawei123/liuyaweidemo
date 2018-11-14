package com.primeton.umsystem.entity;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;

/**
 * 用户状态信息 
 * @author liuya
 *
 * @param <T>
 */
@ApiModel(value = "ResponseResult", description = "用户状态信息管理")
public class ResponseResult<T> {
	
	public static final int SUCCESS_MESSAGE = 1;//没有异常
	public static final int STATE_ERR = 0;//有异常
	public static final int ERROR_USERNAME=1000;//用户名已经存在
	public static final int ERROR_USERNAME_FORMAT=1001;//用户名格式错误
	public static final int ERROR_PASSWORD=1002;//密码错误
	public static final int ERROR_PASSWORD_FORMAT=1003;//密码格式错误
	public static final int ERROR_DELETE=1004;//删除失败
	public static final int ERROR_DNAME=1005;//部门名名字错误
	public static final int ERROR_UPDATE=1006;//更新失败
	
	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	private Integer state;//用户状态吗
	private String message;//用户异常信息记录
	private T data;//用于封装对象信息

	public ResponseResult() {
		super();
	}

	public ResponseResult(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public ResponseResult(Integer state) {
		super();
		setState(state);
	}
	
	public ResponseResult(Integer state, String message) {
		super();
		setState(state);
		setMessage(message);
	}
	
	public ResponseResult(Exception e) {
		super();
		setState(STATE_ERR);
		setMessage(e.getMessage());
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
}