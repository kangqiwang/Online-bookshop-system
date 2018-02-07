package com.jzyqd.servlet.qt;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzyqd.dao.IBookDiscussDAO;
import com.jzyqd.dao.IBookInfoDAO;
import com.jzyqd.dao.IBookTypeDAO;
import com.jzyqd.dao.impl.BookDiscussDAOImpl;
import com.jzyqd.dao.impl.BookInfoDAOImpl;
import com.jzyqd.dao.impl.BookTypeDAOImpl;
import com.jzyqd.entity.BookDiscuss;
import com.jzyqd.entity.BookInfo;
import com.jzyqd.entity.BookType;

public class ShowBookInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		BookInfo bookInfo = bookInfoDAO.findById(id);
		
		IBookDiscussDAO bookDiscussDAO = new BookDiscussDAOImpl();
		//得到当前图书的所有书评
		List<BookDiscuss> bookDiscusses = bookDiscussDAO.findByBookId(id);
		List<BookInfo> rxBooks = bookInfoDAO.findBySaleCount(10);
		
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		Map<BookType, List<BookType>> bookTypes = new Hashtable<BookType, List<BookType>>();
		List<BookType> fuqins = bookTypeDAO.findByParentId(0);
		for (BookType fuqin : fuqins) {
			//得到每个父类别的所有子类别
			List<BookType> erzi = bookTypeDAO.findByParentId(fuqin.getBookTypeId());
			bookTypes.put(fuqin, erzi);
		}
		
		
		
		
		request.setAttribute("bookInfo", bookInfo);
		request.setAttribute("bookDiscusses", bookDiscusses);
		request.setAttribute("rxBooks", rxBooks);
		request.setAttribute("bookTypes", bookTypes);
		
		request.getRequestDispatcher("bookInfo.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
