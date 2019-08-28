package com.it.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.it.dao.StudentDao;
import com.it.dao.impl.StudentDaoImpl;
import com.it.domian.Student;
import com.it.service.StudentService;

public class StudentServiceImpl implements StudentService {

	
	@Override
	public List<Student> findAll() throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	@Override
	public int AddStudent(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.AddStudent(student);
	}

	@Override
	public int DelStudent(int id) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.DelStudent(id);
	}

	@Override
	public Student findStudentById(int id) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findStudentById(id);
	}

	@Override
	public void updateStudent(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.updateStudent(student);
	}

}
