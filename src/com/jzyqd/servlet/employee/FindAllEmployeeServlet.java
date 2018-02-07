package com.jzyqd.servlet.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzyqd.dao.IEmployeeDAO;
import com.jzyqd.dao.impl.EmployeeDAOImpl;
import com.jzyqd.entity.Employee;
import com.jzyqd.tool.Config;

public class FindAllEmployeeServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageSize = Config.PAGESIZE;
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		int pageCount = 0;
		List<Employee> emps = null;
		
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		pageCount = employeeDAO.getPageCount(pageSize);
		emps = employeeDAO.getNowPageData(nowPage, pageSize);
		
		request.setAttribute("emps", emps);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageCount", pageCount);
		
		RequestDispatcher rd = 
			request.getRequestDispatcher("/background/empList.jsp");
		rd.forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
