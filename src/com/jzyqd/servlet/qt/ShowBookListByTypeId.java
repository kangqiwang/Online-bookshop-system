package com.jzyqd.servlet.qt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzyqd.dao.IBookInfoDAO;
import com.jzyqd.dao.impl.BookInfoDAOImpl;
import com.jzyqd.entity.BookInfo;

public class ShowBookListByTypeId extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		List<BookInfo> bookInfos = bookInfoDAO.findByTypeId(typeId);
		request.setAttribute("bookInfos", bookInfos);
		request.getRequestDispatcher("/bookInfoList.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
