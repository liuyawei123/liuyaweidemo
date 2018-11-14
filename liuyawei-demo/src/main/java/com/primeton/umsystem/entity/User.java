package com.primeton.umsystem.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体类用于把数据转化为对象
 * @author liuyawei
 *
 */
@ApiModel(value = "User", description = "用户信息")
@Component
public class User implements Serializable{
	
	
	private static final long serialVersionUID = 8019720987325936224L;
	@ApiModelProperty(value="用户ID")
	private Integer id;
	@ApiModelProperty(value="员工号")
	private String empno;
	@ApiModelProperty(value="用户名")
	private String ename;
	@ApiModelProperty(value="密码")
	private String password;
	@ApiModelProperty(value="职位")
	private String job;
	@ApiModelProperty(value="上级领导")
	private String mgr;
	@ApiModelProperty(value="创建人")
	private String createdUser;
	@ApiModelProperty(value="创建时间")
	private Date createdDate;
	@ApiModelProperty(value="修改用户")
	private String modifiedUser;
	@ApiModelProperty(value="修改用户")
	private Date modifiedDate;
	@ApiModelProperty(value="部门号")
	private String deptno;
	
	
	public User() {
		super();
	}


	

	public User(String empno, String ename, String password, String job, String mgr, String deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.password = password;
		this.job = job;
		this.mgr = mgr;
		this.deptno = deptno;
	}

	public User(String ename, String password) {
		super();
		this.ename = ename;
		this.password = password;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", empno=" + empno + ", ename=" + ename + ", password=" + password + ", job=" + job
				+ ", mgr=" + mgr + ", createdUser=" + createdUser + ", createdDate=" + createdDate + ", modifiedUser="
				+ modifiedUser + ", modifiedDate=" + modifiedDate + ", deptno=" + deptno + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmpno() {
		return empno;
	}


	public void setEmpno(String empno) {
		this.empno = empno;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public String getMgr() {
		return mgr;
	}


	public void setMgr(String mgr) {
		this.mgr = mgr;
	}


	public String getCreatedUser() {
		return createdUser;
	}


	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String getModifiedUser() {
		return modifiedUser;
	}


	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public String getDeptno() {
		return deptno;
	}


	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
}
