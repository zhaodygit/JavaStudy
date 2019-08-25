package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import com.it.domian.Student;

/**
 * 学生表的数据库访问
 * @author admin
 *
 */
public interface StudentDao {
	
	/**
	 * 查询所有的学生
	 * @return
	 */
	List<Student> findAll() throws SQLException;
	
	/**
	 * 添加学生
	 * @param student
	 * @return
	 * @throws SQLException
	 */
	int AddStudent(Student student) throws SQLException;

	/**
	 * 删除学生
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int DelStudent(int id) throws SQLException;
}
