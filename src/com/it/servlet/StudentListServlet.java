package com.it.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.dao.StudentDao;
import com.it.dao.impl.StudentDaoImpl;
import com.it.domian.Student;
import com.it.service.StudentService;
import com.it.service.impl.StudentServiceImpl;

/**
 * 查询所有的学生信息
 */
@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> list = null;
		try {
			//获取数据
			StudentService service = new StudentServiceImpl();
			list = service.findAll();
			//数据存入域
			request.setAttribute("list", list);
			//跳转页面
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
