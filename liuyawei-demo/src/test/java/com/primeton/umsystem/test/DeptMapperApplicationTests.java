package com.primeton.umsystem.test;

import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.primeton.umsystem.LiuyaweiDemoApplication;
import com.primeton.umsystem.dao.IOrgMapper;
import com.primeton.umsystem.entity.Dept;
import com.primeton.umsystem.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LiuyaweiDemoApplication.class) 

public class DeptMapperApplicationTests {

	
		@Autowired
	    private IOrgMapper deptMapper;
		
		/**
		 * 查询测试部门员工
		 */
		@Test
		public void testQureyDeptno() {
			List<User> list=deptMapper.queryEmpUserByDeptno("1");
			for(User user:list) {
				assertNull(user);
			}
			
		}
		/**
		 * 查询测试部门子部门
		 */
		@Test
		public void testQuerychild() {
			List<Dept> list=deptMapper.querychildByLeader("1");
			for(Dept dept:list) {
				assertNull(dept);
			}
		}
		/**
		 * 插入
		 */
		@Test
		public void testInsertDept() {
			Dept dept=new Dept("123","123","123","123");
			Integer rows=deptMapper.insertDept(dept);
			Assert.assertEquals("1", rows);
		}
		/**
		 * 删除
		 */
		@Test
		public void testDeleteDept() {
			Integer rows=deptMapper.deleteDept("123");
			Assert.assertEquals("1", rows);
		}
		/**
		 * 修改
		 */
		@Test
		public void testUpdatetDept() {
			
			Integer rows=deptMapper.updateDeptInfo("123", "1","123");
			Assert.assertEquals("1", rows);
		}

		@Test
		public void testGetDeptByDeptName() {
			Dept dept = deptMapper.getDeptByDeptName("研发1");
			assertNull(dept);

			
		}
		@Test
		public void testGetDeptByDeptno() {
			String deptno = "4";
			Dept dept = deptMapper.getDeptByDeptno(deptno);
			assertNull(dept);

			
		}
	
	
	}


