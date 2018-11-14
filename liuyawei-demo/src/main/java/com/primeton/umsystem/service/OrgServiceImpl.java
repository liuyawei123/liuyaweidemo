package com.primeton.umsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeton.umsystem.dao.IOrgMapper;
import com.primeton.umsystem.entity.Dept;
import com.primeton.umsystem.entity.ResponseResult;
import com.primeton.umsystem.entity.User;
import com.primeton.umsystem.service.excption.ServiceException;

@Service("deptService")
public class OrgServiceImpl implements IOrgService{

	@Autowired
	IOrgMapper deptMapper;
	
	
	/**
	 * 查询该公司所有员工
	 */
	@Override
	public List<User> queryAllUser() {
		List<User> users=deptMapper.queryAllUser();
		return users;
	}
	
	/**
	 * 根据子部门编号查询下属员工的信息
	 */
	@Override
	public List<User> queryEmpUserByDeptno(String deptno) {
		return deptMapper.queryEmpUserByDeptno(deptno);
	}
	
	/**
	 * 根据上级领导部门查询子部门信息
	 */
	@Override
	public List<Dept> querychildByLeader(String leader) {
		return deptMapper.querychildByLeader(leader);
	}
	
	/**
	 * 根据部门号查询部门信息
	 */
	@Override
	public Dept getDeptByDeptno(String deptno) {
		return deptMapper.getDeptByDeptno(deptno);
	}
	
	/**
	 * 根据部门名称查询部门信息
	 */
	@Override
	public Dept getDeptByDeptName(String dname) {
		return deptMapper.getDeptByDeptName(dname);
	}
	
	/**
	 * 插入新的部门信息，根据用户名查询部门信息判断该部门是否存在则插入 否则抛出异常
	 */
	@Override
	public Dept createDept(Dept dept) {
		System.out.println("创建对象："+dept);
		Dept data = getDeptByDeptName(dept.getDname());
		if(data == null) {
			deptMapper.insertDept(dept);
		}else {
			throw new ServiceException(
					"用户名(" + dept.getDname() + ")已经被注册！",ResponseResult.ERROR_DNAME);
		}
		return dept;
	}
	
	/**
	 * 根据部门编号查询子部门信息，根据部门编号查询该部门所有员工的信息
	 * 只有当子部门下属员工的为空的时候或者下属部门为空的是后才能删除
	 * 否则提示不能删除
	 */
	@Override
	public Integer removeDept(String deptno) {
		List<User> userList = queryEmpUserByDeptno(deptno);
		List<Dept> deptList = querychildByLeader(deptno);
		Integer row;
		if(userList.size()==0&&deptList.size()==0) {
			row=deptMapper.deleteDept(deptno);
			if(row!=1) {
				System.out.println("删除出现错误");
				throw new ServiceException("删除失败",ResponseResult.ERROR_DELETE);
			}
			return row;
		}else {
			throw new ServiceException("删除失败，有下属人员或部门",ResponseResult.ERROR_DELETE);
		}
		
	}
    /**
     * 根据部门编号更新部门信息 只能更新部门名称和部门地址
     * 逻辑：
     *     根据部门编号查询部门信息如果为空则没有该部门抛出异常
     *     如果不为空说明有该部门可以修改 
     *     在修改的同事有可能多人是操作数据库所以抛出异常跟心失败
     */
	@Override
	public Integer updateDeptInfo(String dname, String loc, String deptno) {
		Dept data = getDeptByDeptno(deptno);
		if(data==null) {
			throw new ServiceException("没有该部门",ResponseResult.ERROR_UPDATE);
		}else {
			Dept dept = getDeptByDeptName(dname);
			if(dept == null) {
				data.setDname(dname);
				data.setLoc(loc);
				Integer rows = deptMapper.updateDeptInfo(dname, loc, deptno);
				if(rows!=1) {
					throw new ServiceException("更新失败",ResponseResult.ERROR_UPDATE);
				}
			}else  {
				data.setLoc(loc);
				deptMapper.updateDeptInfo(dname, loc, deptno);
			}
		}

		return 1;
	}



}
