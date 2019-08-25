package com.it.service;

import java.sql.SQLException;
import java.util.List;

import com.it.domian.Student;

public interface StudentService {

	/**
	 * 查询所有学生
	 * @return
	 * @throws SQLException
	 */
	public List<Student> findAll() throws SQLException; 

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
