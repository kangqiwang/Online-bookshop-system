package com.jzyqd.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.jzyqd.dao.IOrderMainDAO;
import com.jzyqd.db.DBManager;
import com.jzyqd.entity.OrderMain;

public class OrderMainDAOImpl implements IOrderMainDAO{

	public boolean save(Connection mycon, OrderMain orderMain) {
		String sql = 
			"insert into " +
			"	OrderMain (orderNum,customerId,customerName,tel,address," +
			"				status,adminId,context,sumprice)" +
			" values('"+orderMain.getOrderNum()+"'," +
					"'"+orderMain.getCustomerId()+"'," +
					"'"+orderMain.getCustomerName()+"'," +
					"'"+orderMain.getTel()+"'," +
					"'"+orderMain.getAddress()+"',0,null," +
					"'"+orderMain.getContext()+"'," +
					 "'"+orderMain.getSumprice()+"')";
		System.out.println(sql);
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql, mycon) == 1);
	}
	
	public boolean save(OrderMain orderMain) {
		String sql = 
			"insert into " +
			"	OrderMain (orderNum,customerId,customerName,tel,address," +
			"				status,adminId,context,sumprice)" +
			" values('"+orderMain.getOrderNum()+"'," +
					"'"+orderMain.getCustomerId()+"'," +
					"'"+orderMain.getCustomerName()+"'," +
					"'"+orderMain.getTel()+"'," +
					"'"+orderMain.getAddress()+"',0,null," +
					"'"+orderMain.getContext()+"'," +
					 "'"+orderMain.getSumprice()+"')";
		System.out.println(sql);
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql = "delete from OrderMain where orderNum =" +id;
		System.out.println(sql);
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(OrderMain orderMain) {
		String sql = "update OrderMain set customerId='"+orderMain.getCustomerId()+"'," +
				"customerName='"+orderMain.getCustomerName()+"',tel='"+orderMain.getTel()+"',address='"+orderMain.getAddress()+"'," +
						"status='"+orderMain.getStatus()+"',adminId='"+orderMain.getAdminId()+"',context='"+orderMain.getContext()+"',sumprice='"+orderMain.getSumprice()+"'" +
								" where orderNum ='"+orderMain.getOrderNum()+"'";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public OrderMain findById(int id) {
		String sql = "select orderNum,customerId,customerName,tel,address,status,adminId,context,sumprice " +
				"from OrderMain " +
				"where orderNum = "+id;
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		OrderMain orderMain = null;
		try {
			while(rs.next()){
				 orderMain = new OrderMain(rs.getString("orderNum"),
						rs.getInt("customerId"),
						rs.getString("customerName"),
						rs.getString("tel"), 
						rs.getString("address"), 
						rs.getString("status"),
						rs.getInt("adminId"),
						rs.getString("context"), 
						rs.getFloat("sumprice"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderMain;
	}

	public List<OrderMain> findAll() {
		List<OrderMain> orderMains = new Vector<OrderMain>();
		String sql = "select orderNum,customerId,customerName,tel,address,status,adminId,context,sumprice from OrderMain";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()){
				OrderMain orderMain = new OrderMain(rs.getString("orderNum"),
						rs.getInt("customerId"),
						rs.getString("customerName"),
						rs.getString("tel"), 
						rs.getString("address"), 
						rs.getString("status"),
						rs.getInt("adminId"),
						rs.getString("context"), 
						rs.getFloat("sumprice")); 
				orderMains.add(orderMain);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderMains;
	}

}
