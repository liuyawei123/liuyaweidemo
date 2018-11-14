package com.primeton.umsystem.controller;

import javax.servlet.http.HttpSession;

/**
 * 所有控制器的基类
 * @author liuya
 */
public abstract class BaseController {

	/**
	 * 从Session中获取用户的ename
	 * @param session HttpSession对象
	 * @return 用户ename
	 */
	protected final String getUsernameSession(HttpSession session) {
		return   (String) session.getAttribute("ename");

	}
	/**
	 * 从Session中获取用户的id
	 * @param session HttpSession对象
	 * @return 用户的id
	 */
	protected final String getUidFromSession(HttpSession session) {
		return (String) session.getAttribute("id");
	}

}