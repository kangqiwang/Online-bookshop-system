package com.jzyqd.servlet.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzyqd.dao.IEmployeeDAO;
import com.jzyqd.dao.impl.EmployeeDAOImpl;

public class DeleteEmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		String msg = "ɾ��Ա����Ϣʧ��!!";
		if (employeeDAO.delete(id)) {
			msg = "ɾ��Ա����Ϣ�ɹ�!!";
		} 
		request.setAttribute("msg", msg);
		request.setAttribute("returnPath", "/FindAllEmployeeServlet?nowPage=1");
		RequestDispatcher rd = request.getRequestDispatcher("/background/msg.jsp");
		rd.forward(request, response);	
		
	}


}
