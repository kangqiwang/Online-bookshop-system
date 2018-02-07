package com.jzyqd.servlet.sysAdmin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jzyqd.dao.ISysAdminDAO;
import com.jzyqd.dao.impl.SysAdminDAOImpl;
import com.jzyqd.entity.SysAdmin;

public class BackgroundLoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		ISysAdminDAO sysAdminDAO = new SysAdminDAOImpl();
		SysAdmin sysAdmin = sysAdminDAO.findByNameAndPwd(name, pwd);
		String path = "login.jsp";
		if (sysAdmin != null) {
			path = "index.jsp";
			//把当前登录用户的详细信息(entity)放入session
			HttpSession session = request.getSession();
			session.setAttribute("sysAdmin", sysAdmin);
		} 
		response.sendRedirect("background/" + path);
		
	}

}
