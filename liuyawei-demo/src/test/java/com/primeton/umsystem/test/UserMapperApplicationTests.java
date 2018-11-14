package com.primeton.umsystem.test;

import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.primeton.umsystem.LiuyaweiDemoApplication;
import com.primeton.umsystem.dao.IUserMapper;
import com.primeton.umsystem.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LiuyaweiDemoApplication.class) 

public class UserMapperApplicationTests {

	
		@Autowired
	    private IUserMapper userMapper;
		/**
		 * 注册
		 */
		@Test
		public void TestAddUserTest() {
			System.out.println("开始进行单元测试");
			User user=new User();
			user.setEname("刘亚威");
			user.setPassword("123");
			user.setCreatedDate(new Date());
			Integer a=userMapper.insertUser(user);
			assertNull(a);
		}
		/**
		 * 查询
		 */
		@Test
		public void testGetUsernameTest() {
			User user=userMapper.getUserByName("刘亚威");
			assertNull(user);
		}
		/**
		 * 删除用户
		 */
		@Test
		public void testDeleteTest() {
			Integer row=userMapper.deleteUser("王力宏");
			Assert.assertEquals("1", row);
		}
		@Test
		public void testUpdatatest() {
			User user=userMapper.getUserByName("aa");
			System.out.println("用户id:"+user.getId());
			user.setEname("aaa");
			user.setPassword("12345");
			userMapper.updateUser(user);
			assertNull(user);
			
			
		}
	}


