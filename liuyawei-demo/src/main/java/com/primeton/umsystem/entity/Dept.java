package com.primeton.umsystem.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 部门实体类
 * @author liuya
 *
 */
@ApiModel(value = "UserBean", description = "部门信息")
public class Dept implements Serializable{
	public Dept(String deptno, String dname, String loc, String leader) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		this.leader = leader;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 3721673760609073354L;
	@ApiModelProperty(value="部门号")
	private String  deptno;
	@ApiModelProperty(value="部门名称")
	private String  dname;
	@ApiModelProperty(value="部门地址")
	private String loc;
	@ApiModelProperty(value="上级部门")
	private String leader;
	@ApiModelProperty(value="部门ID")
	private Integer id;
	
	
	public Dept() {
		super();
	}
	
	@Override
	public String toString() {
		return "dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", leader=" + leader + ", id=" + id
				+ "]";
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	

}
