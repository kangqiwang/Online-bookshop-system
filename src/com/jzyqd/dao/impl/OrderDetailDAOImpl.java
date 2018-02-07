package com.jzyqd.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.jzyqd.dao.IOrderDetailDAO;
import com.jzyqd.db.DBManager;
import com.jzyqd.entity.OrderDetail;

public class OrderDetailDAOImpl implements IOrderDetailDAO{

	public boolean save(OrderDetail orderDetail) {
		String sql = "insert into OrderDetail (orderNum,bookId,num) " +
				"values ('"+orderDetail.getOrderNum()+"','"+orderDetail.getBookId()+"','"+orderDetail.getNum()+"')";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql = "delete from OrderDetail where detail="+id;
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(OrderDetail orderDetail) {
		String sql = "update OrderDetail set orderNum='"+orderDetail.getOrderNum()+"',bookId='"+orderDetail.getBookId()+"',num='"+orderDetail.getNum()+"' " +
				"where detail = '"+orderDetail.getDetail()+"'";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public OrderDetail findById(int id) {
		String sql = "select detail,orderNum,bookId,num from OrderDetail where detail="+id;
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		OrderDetail orderDetail = null;
		try {
			while(rs.next()){
				orderDetail = new OrderDetail(rs.getInt("detail"), 
						rs.getString("orderNum"),
						rs.getInt("bookId"),
						rs.getInt("num"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderDetail;
	}

	public List<OrderDetail> findAll() {
		List<OrderDetail> orderDetails = new Vector<OrderDetail>();
		String sql = "select detail,orderNum,bookId,num from OrderDetail";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()){
				OrderDetail orderDetail = new OrderDetail(rs.getInt("detail"), 
							rs.getString("orderNum"),
							rs.getInt("bookId"),
							rs.getInt("num"));
				orderDetails.add(orderDetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderDetails;
	}

	public boolean save(List<OrderDetail> orderDetails) {
		DBManager dbManager = new DBManager();
		try {
			for (OrderDetail orderDetail : orderDetails) {
				String sql = "insert into OrderDetail (orderNum,bookId,num) " +
				"values ('"+orderDetail.getOrderNum()+"','"+orderDetail.getBookId()+"','"+orderDetail.getNum()+"')";
				dbManager.update(sql);
			}	
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean save(Connection mycon, List<OrderDetail> orderDetails) {
		DBManager dbManager = new DBManager();
		try {
			for (OrderDetail orderDetail : orderDetails) {
				String sql = "insert into OrderDetail (orderNum,bookId,num) " +
				"values ('"+orderDetail.getOrderNum()+"','"+orderDetail.getBookId()+"','"+orderDetail.getNum()+"')";
				dbManager.update(sql, mycon);
			}	
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
