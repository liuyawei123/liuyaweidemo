package com.primeton.umsystem.service;

import org.apache.ibatis.annotations.Select;

import com.primeton.umsystem.entity.User;

/**
 * 业务层方法接口
 * @author liuyawei
 *
 */
public interface IUserService {
	/**
	 * 注册功能，即向表中插入数据
	 * @param user 用户插入的数据对象
	 * @return  受影响的行数
	 */
	User insertUser(User user);
	/**
	 * 根据用户名删除用户
	 * @param ename  用户名
	 * @return 收影响的行数
	 */
	Integer removeUser(String ename);

	/**
	 * 根据用户名查询用户数据
	 * @param ename 用户名
	 * @return 与参数用户名匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	public User getUserByName(String ename);
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 用户密码
	 * @return  用户个信息
	 */
	User login(String username, String password);
	/**
	 *用户修改个人信息
	 * @param ename  新用户名
	 * @param password 新的密码
	 * @param 用户id
	 * @return  受影响的行数
	 */
	Integer modifyInfo(String ename, String password,Integer id);
}
