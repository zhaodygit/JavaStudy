package com.it.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.it.dao.StudentDao;
import com.it.domian.Student;
import com.it.uitl.JDBCUtil02;
import com.it.uitl.TextUtil;

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

	@Override
	public Student findStudentById(int id) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from stu where id=?", new BeanHandler<Student>(Student.class), id);
	}

	@Override
	public void updateStudent(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("update stu set sname=?,"
				+ "gender=?,"
				+ "phone=?,"
				+ "birthday=?,"
				+ "hobby=?,"
				+ "info=? "
				+ "where id = ?", 
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo(),
				student.getId());
	}

	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from stu where 1=1 ";
		List<String> list = new ArrayList<>();
		if(!TextUtil.isEmpty(sname)) {
			sql = sql + " and sname like ?";
			list.add("%"+ sname + "%");
		}
		if(!TextUtil.isEmpty(sgender)) {
			sql = sql + " and gender = ?";
			list.add(sgender);
		}
		
		
		return  runner.query(sql, new BeanListHandler<Student>(Student.class),list.toArray());
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select * from stu where 1=1 ";
		/*List<String> list = new ArrayList<>();
		if(!TextUtil.isEmpty(sname)) {
			sql = sql + " and sname like ?";
			list.add("%"+ sname + "%");
		}
		if(!TextUtil.isEmpty(sgender)) {
			sql = sql + " and gender = ?";
			list.add(sgender);
		}*/ 
		sql += " limit ? offset ?";
		
		return  runner.query(sql, new BeanListHandler<Student>(Student.class), PAGE_SIZE, (currentPage-1)*PAGE_SIZE);
	}

	@Override
	public int findCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		String sql = "select count(id) from stu where 1=1 ";
		Long result =  (Long)runner.query(sql, new ScalarHandler());
		
		return result.intValue();
	}

}
