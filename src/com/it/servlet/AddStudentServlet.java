package com.it.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.domian.Student;
import com.it.service.StudentService;
import com.it.service.impl.StudentServiceImpl;

/**
 * 处理学生的添加请求
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String hobby = request.getParameter("hobby");
		String info = request.getParameter("info");
		String[] h = request.getParameterValues("hobby");
		
		hobby = Arrays.toString(h);
		hobby = hobby.substring(1, hobby.length()-1);
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student student = new Student(sname, gender, phone,date,hobby,info);
			
			StudentService service = new StudentServiceImpl();
			service.AddStudent(student);
			
			//request.getRequestDispatcher("list.jsp").forward(request, response);
			
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
