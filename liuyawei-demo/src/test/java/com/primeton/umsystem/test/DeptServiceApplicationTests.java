package com.primeton.umsystem.test;

import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.primeton.umsystem.LiuyaweiDemoApplication;
import com.primeton.umsystem.entity.Dept;
import com.primeton.umsystem.service.IOrgService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LiuyaweiDemoApplication.class) 

public class DeptServiceApplicationTests {

	
		@Autowired
	    private IOrgService deptService;
		
		@Test
		public void testInsertDept() {
			Dept dept = new Dept();
			dept.setDeptno("10");
			dept.setDname("开发2222");
			dept.setLeader("3");
			Dept res = deptService.createDept(dept);
			assertNull(res);
		}
		
		@Test
		public void testDelete() {
			Integer row = deptService.removeDept("44");
			Assert.assertEquals("1", row);
		}
		
		@Test
		public void  testGetDeptByDeptName() {
			Dept row = deptService.getDeptByDeptName("研发1");
			Assert.assertEquals("1", row);

		}
		@Test
		public void testUpdate() {
			Integer row = deptService.updateDeptInfo("研发2", "shanghai", "4");
			Assert.assertEquals("1", row);

		}
	

		
	
	}


