package com.jzyqd.servlet.qt;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzyqd.dao.IBookInfoDAO;
import com.jzyqd.dao.IBookTypeDAO;
import com.jzyqd.dao.impl.BookInfoDAOImpl;
import com.jzyqd.dao.impl.BookTypeDAOImpl;
import com.jzyqd.entity.BookInfo;
import com.jzyqd.entity.BookType;
import com.jzyqd.entity.News;

public class InitIndexServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**1  获取各种数据**/
		//1)新闻列表
		List<News> news = null;
		//2)最新商品 按照上架日期的降序排列 top5
		List<BookInfo> zxBooks = null;
		//3)热销商品=最新排行  根据商品的累积销售量降序 top10
		List<BookInfo> rxBooks = null;
		//4)推荐商品  随机显示10条
		List<BookInfo> tjBooks = null;
		//5) 图书类别
		Map<BookType, List<BookType>> bookTypes = new Hashtable<BookType, List<BookType>>();
		
		
		//1)新闻列表
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		//2)最新商品 
		zxBooks = bookInfoDAO.findBySJDate(5);
		//3)热销商品
		rxBooks = bookInfoDAO.findBySaleCount(10);
		//4)推荐商品
		tjBooks = bookInfoDAO.findAll();
		//5) 图书类别
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		//得到所有的父类别(顶层类别)
		List<BookType> fuqins = bookTypeDAO.findByParentId(0);
		for (BookType fuqin : fuqins) {
			//得到每个父类别的所有子类别
			List<BookType> erzi = bookTypeDAO.findByParentId(fuqin.getBookTypeId());
			bookTypes.put(fuqin, erzi);
		}
		
		
		//把数据放入request patameter的范围
		request.setAttribute("news", news);
		request.setAttribute("zxBooks", zxBooks);
		request.setAttribute("rxBooks", rxBooks);
		request.setAttribute("tjBooks", tjBooks);
		request.setAttribute("bookTypes", bookTypes);
		
		
		
		//请求转发到index.jsp
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
