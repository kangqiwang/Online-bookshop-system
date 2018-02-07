package com.jzyqd.servlet.gwc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jzyqd.dao.ICustomerDetailInfoDAO;
import com.jzyqd.dao.ICustomerInfoDAO;
import com.jzyqd.dao.impl.CustomerDetailInfoDAOImpl;
import com.jzyqd.dao.impl.CustomerInfoDAOImpl;
import com.jzyqd.entity.CustomerDetailInfo;
import com.jzyqd.entity.CustomerInfo;

public class QTLoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ICustomerInfoDAO customerInfoDAO = new CustomerInfoDAOImpl();
		CustomerInfo customerInfo = customerInfoDAO.findByNameAndPwd(username, password);
		if (customerInfo == null) {
			response.sendRedirect("qtlogin.jsp");
		} else {
			ICustomerDetailInfoDAO customerDetailInfoDAO = new CustomerDetailInfoDAOImpl();
			CustomerDetailInfo customerDetailInfo = customerDetailInfoDAO.findById(customerInfo.getCustId());
			HttpSession session = request.getSession();
			session.setAttribute("customerInfo", customerInfo);
			session.setAttribute("customerDetailInfo", customerDetailInfo);
			response.sendRedirect("makeOrder.jsp");	
		}
	
	}

}
