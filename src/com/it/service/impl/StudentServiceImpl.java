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

}
