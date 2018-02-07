package com.jzyqd.servlet.gwc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jzyqd.dao.IBookInfoDAO;
import com.jzyqd.dao.impl.BookInfoDAOImpl;
import com.jzyqd.entity.BookInfo;

public class AddGwcItemServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		BookInfo bookInfo = bookInfoDAO.findById(id);
		
		GwcItem gwcItem = new GwcItem();
		gwcItem.setNum(1);
		gwcItem.setBookId(id);
		gwcItem.setBookName(bookInfo.getBookName());
		gwcItem.setPrice(bookInfo.getPrice());
		gwcItem.setSmallImg(bookInfo.getSmallImg());
		gwcItem.setHyprice(bookInfo.getHyprice());
		
		Gwc gwc = null;
		HttpSession session = request.getSession();
		if (session.getAttribute("gwc") == null) {
			gwc = new Gwc();
		} else {
			gwc = (Gwc)session.getAttribute("gwc");
		}
		gwc.addItem(gwcItem);
		session.setAttribute("gwc", gwc);
		
		response.sendRedirect("gwc.jsp");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
