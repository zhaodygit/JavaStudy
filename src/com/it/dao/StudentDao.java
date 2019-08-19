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
}
