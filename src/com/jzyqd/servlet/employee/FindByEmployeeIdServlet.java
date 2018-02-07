package com.jzyqd.servlet.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzyqd.dao.IEmployeeDAO;
import com.jzyqd.dao.impl.EmployeeDAOImpl;
import com.jzyqd.entity.Employee;

public class FindByEmployeeIdServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		Employee emp = employeeDAO.findById(id);
		request.setAttribute("emp", emp);
		RequestDispatcher rd = request.getRequestDispatcher("background/updateEmp.jsp");
		rd.forward(request, response);
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
