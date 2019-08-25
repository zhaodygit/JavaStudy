package com.it.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.it.dao.StudentDao;
import com.it.domian.Student;
import com.it.uitl.JDBCUtil02;

public class StudentDaoImpl implements StudentDao{

	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from stu";
		List<Student> list = runner.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
	}

	@Override
	public int AddStudent(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "insert into stu values(null,?,?,?,?,?,?)";
		System.out.println(student);
		return runner.update(sql,
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo()
				);
	}

	@Override
	public int DelStudent(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		
		return runner.update("delete from stu where id = ?", id);
	}

}
