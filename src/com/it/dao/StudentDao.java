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
	
	int PAGE_SIZE = 2;  //
	/**
	 * 查询当前页
	 * @return
	 * @throws SQLException
	 */
	List<Student> findStudentByPage(int currentPage) throws SQLException;
	
	/**
	 * 总记录数
	 * @return
	 * @throws SQLException
	 */
	int findCount() throws SQLException;
	
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
	 * 通过id查询学生
	 * @param id
	 * @return
	 */
	Student findStudentById(int id) throws SQLException;
	/**
	 * 删除学生
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int DelStudent(int id) throws SQLException;
	
	/**
	 * 更新学生
	 * @param student
	 * @throws SQLException
	 */
	void updateStudent(Student student) throws SQLException;

	/**
	 * 学生查询
	 * @param sname
	 * @param sgender
	 * @return
	 * @throws SQLException
	 */
	List<Student> searchStudent(String sname, String sgender) throws SQLException;
}
