package com.primeton.umsystem.test;

import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.primeton.umsystem.LiuyaweiDemoApplication;
import com.primeton.umsystem.entity.User;
import com.primeton.umsystem.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LiuyaweiDemoApplication.class) 

public class UserServerApplicationTests {

	
		@Autowired
	    private IUserService userService;
		/**
		 * 添加用户
		 */
		@Test
		public void testAddUserTest() {
			System.out.println("开始进行单元测试");
			User user=new User();
			user.setEmpno("111");
			user.setEname("王力宏");
			user.setPassword("123");
			
			userService.insertUser(user);
			assertNull(user);
		}
		/**
		 * 用户登录
		 */
		@Test
		public void testLoginTest() {
			User user=userService.login("周杰伦", "123");
			assertNull(user);
		}
		@Test
		public void testUpdateTest() {
			Integer rows=userService.modifyInfo("aaaaa","123",2);
			Assert.assertEquals("1", rows);
		}
	
	}


