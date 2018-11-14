package com.primeton.umsystem.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.primeton.umsystem.entity.User;

/**
 * 数据操作接口以及数据库增删查改
 * @author liuyawei
 */
@Mapper // 声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可

public interface IUserMapper {



	/**
	 * 注册功能，即向表中插入数据
	 * @param user 用户插入的数据对象
	 * @return  数据对象
	 */
	@Insert("INSERT INTO "
			+ "LYW_PRIMETON_EMP "
			+ "(EMPNO,EMP_NAME,PASSWORD,JOB,MGR,CREATE_DATE,CREATE_USER,"
			+ " MODIFIED_DATE,MODIFIED_USER,DEPTNO) "
			+ "VALUES"
			+ " (#{empno},#{ename},#{password},#{job},#{mgr},"
			+ "#{createdDate},#{createdUser},#{modifiedDate},#{modifiedUser},#{deptno})")
	public Integer insertUser(User user);

	/**
	 * 根据用户名查询用户数据
	 * @param ename 用户名
	 * @return 与参数用户名匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	@Select("SELECT "
			+ "EMP_ID AS id, EMPNO,EMP_NAME AS ename,PASSWORD,JOB,MGR,"
			+ "CREATE_DATE,CREATE_USER, MODIFIED_DATE,"
			+ "MODIFIED_USER  AS modifiedUser,DEPTNO FROM LYW_PRIMETON_EMP"
			+ " WHERE"
			+ " EMP_NAME = #{ename}")
	public User getUserByName(String ename);
	/**
	 * 根据id查询用户数据
	 * @param id 用户id
	 * @return 与参数用户id匹配的用户数据，如果没有匹配的数据，则返回null
	 */ 
	@Select("SELECT "
			+ "NMPNO,EMP_NAME,PASSWORD,JOP,MGR,"
			+ "CREATE_DATE,CREATE_USER, MODIFIED_DATE,MODIFIED_USER,DEPTNO FROM "
			+ "LYW_PRIMETON_EMP "
			+ "WHERE"
			+ " EMP_ID = #{id}")
	public User getUserById(int id);
	/**
	 * 根据用户名删除用户
	 * @param ename  用户名
	 * @return 收影响的行数
	 */
	@Delete("DELETE FROM LYW_PRIMETON_EMP WHERE EMP_NAME=#{ename}")
	public Integer deleteUser(String ename);

	/**
	 * 根据个人用户名用户修改个人信息
	 * @param user 用户之前的个人信息
	 * @return 收影响的行数
	 */
	@Update("UPDATE LYW_PRIMETON_EMP SET EMP_NAME=#{ename},PASSWORD=#{password} WHERE EMP_ID=#{id}")
	public Integer updateUser(User user);





}
