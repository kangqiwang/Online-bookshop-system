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
		/**1  ��ȡ��������**/
		//1)�����б�
		List<News> news = null;
		//2)������Ʒ �����ϼ����ڵĽ������� top5
		List<BookInfo> zxBooks = null;
		//3)������Ʒ=��������  ������Ʒ���ۻ����������� top10
		List<BookInfo> rxBooks = null;
		//4)�Ƽ���Ʒ  �����ʾ10��
		List<BookInfo> tjBooks = null;
		//5) ͼ�����
		Map<BookType, List<BookType>> bookTypes = new Hashtable<BookType, List<BookType>>();
		
		
		//1)�����б�
		IBookInfoDAO bookInfoDAO = new BookInfoDAOImpl();
		//2)������Ʒ 
		zxBooks = bookInfoDAO.findBySJDate(5);
		//3)������Ʒ
		rxBooks = bookInfoDAO.findBySaleCount(10);
		//4)�Ƽ���Ʒ
		tjBooks = bookInfoDAO.findAll();
		//5) ͼ�����
		IBookTypeDAO bookTypeDAO = new BookTypeDAOImpl();
		//�õ����еĸ����(�������)
		List<BookType> fuqins = bookTypeDAO.findByParentId(0);
		for (BookType fuqin : fuqins) {
			//�õ�ÿ�����������������
			List<BookType> erzi = bookTypeDAO.findByParentId(fuqin.getBookTypeId());
			bookTypes.put(fuqin, erzi);
		}
		
		
		//�����ݷ���request patameter�ķ�Χ
		request.setAttribute("news", news);
		request.setAttribute("zxBooks", zxBooks);
		request.setAttribute("rxBooks", rxBooks);
		request.setAttribute("tjBooks", tjBooks);
		request.setAttribute("bookTypes", bookTypes);
		
		
		
		//����ת����index.jsp
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
