package com.primeton.umsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.primeton.umsystem.entity.Dept;
import com.primeton.umsystem.entity.User;


@Mapper
public interface IOrgMapper {
	/**
	 * 根据该部门号查询该部门的全部人员的信息
	 * @param deptno  部门编号
	 * @return  该部门全部人员信息集合
	 */
	@Select("SELECT"
			+ " E.EMP_ID, E.EMPNO,E.EMP_NAME,E.JOB,E.MGR,E.CREATE_DATE,E.CREATE_USER, "
			+ "E.MODIFIED_DATE,E.MODIFIED_USER  "
			+ "FROM "
			+ "LYW_PRIMETON_EMP E "
			+ "JOIN "
			+ " LYW_PRIMETON_DEPT D "
			+ "ON "
			+ "(E.DEPTNO = D.DEPTNO) "
			+ "WHERE"
			+ " E.DEPTNO=#{deptno}")
	public List<User> queryEmpUserByDeptno(String deptno);
	/**
	 * 
	 * 查询该公司所有员工
	 * @return 该公司所有员工集合
	 */
	@Select("SELECT"
			+ " EMP_ID, EMPNO,EMP_NAME as ename,JOB,MGR,CREATE_DATE,CREATE_USER, "
			+ "MODIFIED_DATE,MODIFIED_USER  "
			+ "FROM "
			+ "LYW_PRIMETON_EMP")
	public List<User> queryAllUser();
	/**
	 * 根据部门名称查询部门信息
	 * @param dname 部门名称
	 * @return 包含部门信息的数据对象
	 */
	@Select("SELECT DEPTNO,DEPT_NAME,LOC,LEADER FROM LYW_PRIMETON_DEPT WHERE DEPT_NAME=#{dname}")
	public Dept getDeptByDeptName(String dname);

	/**
	 * 根据部门号查询部门信息
	 * @param deptno  部门编号
	 * @return 包含部门信息的数据对象
	 */
	@Select("SELECT DEPTNO,DEPT_NAME,LOC,LEADER FROM LYW_PRIMETON_DEPT WHERE DEPTNO=#{deptno}")
	public Dept getDeptByDeptno(String deptno);

	/**
	 * 根据部门号查询附属部门
	 * @param deptno 部门号
	 * @return  
	 */
	@Select("SELECT DEPT_ID,DEPTNO DEPT_NAME,LEADER,LOC FROM LYW_PRIMETON_DEPT WHERE LEADER=#{leader}")
	public List<Dept> querychildByLeader(String leader);

	/**
	 * 添加部门
	 * @param dept  部门数据存放的对象
	 * @return   受影响的行数
	 */
	@Insert("INSERT INTO "
			+ "LYW_PRIMETON_DEPT"
			+ "(DEPTNO,DEPT_NAME,LOC,LEADER) "
			+ "VALUES "
			+ "(#{deptno}, #{dname}, #{loc},#{leader})")
	public Integer insertDept(Dept dept);

	/**
	 * 根据部门号修过部门名称和部门地址
	 * @return 受影响的行数
	 */
	@Update("UPDATE LYW_PRIMETON_DEPT SET DEPT_NAME=#{dname},LOC=#{loc} WHERE DEPTNO=#{deptno}")
	public Integer updateDeptInfo(String dname,String loc,String deptno);

	/**
	 * 根据部门号删除部门
	 * 分析：
	 *     删除高级部门是要判断是否有下属部门存在 如果存在则提示不可删除或者先删除下属部门
	 *     如果没有下属部门则 就要查询是否有下属人员信息如果有则提示不能删除或者提示删除下属人员
	 * @param deptno  部门号
	 * @return 受影响的行数
	 */
	@Delete("DELETE FROM LYW_PRIMETON_DEPT WHERE DEPTNO=#{deptno}  ")
	public Integer deleteDept(String deptno);
}
