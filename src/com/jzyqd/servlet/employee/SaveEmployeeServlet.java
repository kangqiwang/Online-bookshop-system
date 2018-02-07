package com.jzyqd.servlet.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzyqd.dao.IEmployeeDAO;
import com.jzyqd.dao.impl.EmployeeDAOImpl;
import com.jzyqd.entity.Employee;
import com.jzyqd.tool.DateConvert;

public class SaveEmployeeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String empName = request.getParameter("empName");
		int empAge = Integer.parseInt(request.getParameter("empAge"));
		String btdStr = request.getParameter("empBtd");
		int empSex = Integer.parseInt(request.getParameter("empSex"));
		
		Employee employee = new Employee();
		employee.setEmpName(empName);
		employee.setEmpAge(empAge);
		Date btd = DateConvert.convertToDate(btdStr);
		employee.setEmpBtd(btd);
		employee.setEmpSex(empSex);
		employee.setIsDelete(1);
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		String msg = "新增员工信息失败!!";
		String returnPath  = "/background/saveEmp.jsp";
		if (employeeDAO.save(employee)) {
			msg = "新增员工信息成功!!";
			returnPath  = "/FindAllEmployeeServlet?nowPage=1";
		} 
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", returnPath);
		RequestDispatcher rd = request.getRequestDispatcher("/background/msg.jsp");
		rd.forward(request, response);		
		
		
	}

}
