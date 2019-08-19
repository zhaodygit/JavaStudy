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
}
