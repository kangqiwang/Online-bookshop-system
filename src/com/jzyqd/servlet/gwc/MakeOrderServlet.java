package com.jzyqd.servlet.gwc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.security.pkcs11.Secmod.DbMode;

import com.jzyqd.dao.IOrderDetailDAO;
import com.jzyqd.dao.IOrderMainDAO;
import com.jzyqd.dao.impl.OrderDetailDAOImpl;
import com.jzyqd.dao.impl.OrderMainDAOImpl;
import com.jzyqd.db.DBManager;
import com.jzyqd.entity.CustomerDetailInfo;
import com.jzyqd.entity.CustomerInfo;
import com.jzyqd.entity.OrderDetail;
import com.jzyqd.entity.OrderMain;

public class MakeOrderServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CustomerInfo customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
		CustomerDetailInfo customerDetailInfo = (CustomerDetailInfo)session.getAttribute("customerDetailInfo");
		Gwc gwc = (Gwc)session.getAttribute("gwc");
		
		//1 向订单主表添加一条数据
		OrderMain orderMain = new OrderMain();
		//201508102038777
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//订单编号 
		String orderNum = df.format(now);
		orderMain.setOrderNum(orderNum);
		//客户姓名
		int customerId = customerInfo.getCustId();
		orderMain.setCustomerId(customerId);
		//收货人姓名
		String customerName = request.getParameter("customerName");
		orderMain.setCustomerName(customerName);
		//收货人电话
		String tel = request.getParameter("tel");
		orderMain.setTel(tel);
		//收货地址
		String address = request.getParameter("address");
		orderMain.setAddress(address);
		//销售单状态（0-未处理，1-已处理，2-以发货，3-已收货）
		orderMain.setStatus("0");
		//备注
		String context = request.getParameter("context");
		orderMain.setContext(context);
		//总价
		float sumprice = gwc.getHyPrices();
		orderMain.setSumprice(sumprice);
		
		
		//2 向订单明细表添加一条到多条数据
		List<OrderDetail> orderDetails = new Vector<OrderDetail>();
		
		Collection<GwcItem> items = gwc.getAllItems();
		for (GwcItem item : items) {
			OrderDetail orderDetail = new OrderDetail(); 
			//主表ID
			orderDetail.setOrderNum(orderNum);
			//商品编号
			orderDetail.setBookId(item.getBookId());
			//订购数量
			orderDetail.setNum(item.getNum());
			orderDetails.add(orderDetail);
		}
		
		IOrderMainDAO orderMainDAO = new OrderMainDAOImpl();
		IOrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
		Connection mycon = null;
		try {
			DBManager dbManager = new DBManager();
			mycon = dbManager.getCon();
			
			mycon.setAutoCommit(false);
			
			orderMainDAO.save(mycon, orderMain);
			orderDetailDAO.save(mycon, orderDetails);
			
			mycon.commit();
			gwc.clear();
			response.setContentType("text/html; charset=gbk");
			PrintWriter out = response.getWriter();
			out.print("订单编号是:" + orderNum);
		} catch (Exception e) {
			try {
				mycon.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			response.setContentType("text/html; charset=gbk");
			PrintWriter out = response.getWriter();
			out.print("下订单时发生异常!!!");

			e.printStackTrace();
		}
		
		
		
		//3 修改客户详细信息表的累积消费金额
		
		
		
	}

}
