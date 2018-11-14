package com.primeton.umsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.primeton.umsystem.entity.ResponseResult;
import com.primeton.umsystem.entity.User;
import com.primeton.umsystem.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户控制器
 * @author liuya
 *
 */
@Api(value = "用户管理api", tags = "用户管理接口")
@RequestMapping("/api")
@RestController
@Transactional(rollbackFor=Exception.class)
public class UserController extends BaseController{

	@Autowired
	IUserService userService;

	@Autowired
	private User user;

	/**
	 * 用户注册
	 * @param empno 员工号
	 * @param ename 员工姓名
	 * @param password 员工密码
	 * @param job  员工职位
	 * @param mgr  上级领导
	 * @param deptno 部门号
	 * @return 注册状态
	 */
	@PostMapping("/users")
	@ApiOperation(value = "创建用户", response = ResponseResult.class)
	public ResponseResult<User> createUser(//或者用handleReg
			User user
//			@RequestParam("empno")@ApiParam("员工号") String empno,
//			@RequestParam("ename")@ApiParam("员工姓名") String ename,
//			@RequestParam("password")@ApiParam("员工密码") String password,
//			@RequestParam("job")@ApiParam("员工工作") String job,
//			@RequestParam("mgr")@ApiParam("员工的上级领导") String mgr,
//			@RequestParam("deptno")@ApiParam("员工的部门号") String deptno
			) {

		ResponseResult<User> response = null;
		//user = new User(empno,ename,password,job,mgr,deptno);
		//调用业务层的实现注册功能
		user=userService.insertUser(user);
		//封装返回结果
		response = new ResponseResult<User>(ResponseResult.SUCCESS_MESSAGE,"注册成功");
		return response;
	}
	/**
	 * 用户登录
	 * @param ename  用户名
	 * @param password  密码
	 * @param session 记录
	 * @return  记录登录状态
	 */
	@ApiOperation(value = "登录", response = ResponseResult.class)
	@GetMapping("/users/{ename}/{password}")
	public ResponseResult<Void> getUserLogin(
			@PathVariable("ename")@ApiParam("员工姓名") String ename,
			@PathVariable("password")@ApiParam("员工密码") String password,
			HttpSession session) {
		//声明返回值
		ResponseResult<Void> response=null;
		// 执行登录
		User user=userService.login(ename, password);
		// 在Session中存放用户名
		session.setAttribute("ename", ename);
		session.setAttribute("id", user.getId());
		// 返回成功
		response = new ResponseResult<Void>(ResponseResult.SUCCESS_MESSAGE,"恭喜你登录成功");
		return response;

	}
	

	/**
	 * 删除 根据用户名删除该用户
	 * @param ename
	 * @return
	 */
	@ApiOperation(value = "删除用户", response = ResponseResult.class)
	@DeleteMapping(value = "/users/{ename}")
	public ResponseResult<Void> removeUser(//personDelete
			@PathVariable("ename")@ApiParam("员工姓名") String ename,
			@ApiParam("session对象")HttpSession session) {
		String username= getUsernameSession(session);
		if(ename.equals(username)) {
			userService.removeUser(ename);
			return new ResponseResult<Void>(ResponseResult.SUCCESS_MESSAGE,"删除成功");
		}else {
			return new ResponseResult<Void>(ResponseResult.ERROR_DELETE,"请您先登陆");
		}
	}
	/**
	 * 用根据用户id修改个人数据
	 * @param id  用户id
	 * @param ename  用户名
	 * @param password 用户密码
	 * @param session 获取绑定数据
	 * @return 状态信息
	 */
	@ApiOperation(value = "修改用户", response = ResponseResult.class)
	@PutMapping(value="/users")
	public ResponseResult<Void> modifyInfo(//handleChangeInfo
			@RequestParam("id")@ApiParam("员工ID") Integer id,
			@RequestParam("ename")@ApiParam("员工姓名") String ename,
			@RequestParam("password")@ApiParam("员工密码") String password,
			HttpSession session) {
		// 声明返回值
		ResponseResult<Void> rr=null;
		//需要判断是否登陆和判断你输入的是否是自己的ID
		/**
		 * 这地方除了一个长时间按找不到的低级错误，开始使用String类型接受出现restfull异常但是也不抱具体的错误点
		 * 但是不知道具体原因 可能是session数据接受返回值类型问题
		 */
		Integer uid=(Integer) session.getAttribute("id");
		System.out.println(uid+","+ename+","+password);
		if(id.equals(uid)) {
			// 调用业务层对象的方法
			userService.modifyInfo(ename, password, id);
			rr = new ResponseResult<Void>(
					ResponseResult.SUCCESS_MESSAGE,
					"修改成功您的新的账号和密码是：username："+ename+"password:"+password);
			// 执行返回
			return rr;
		}else {
			return new ResponseResult<Void>(ResponseResult.ERROR_DELETE,"请您先登陆");
		}
	}
}
