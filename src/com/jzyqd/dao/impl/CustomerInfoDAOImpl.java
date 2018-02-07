package com.jzyqd.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.jzyqd.dao.ICustomerInfoDAO;
import com.jzyqd.db.DBManager;
import com.jzyqd.entity.CustomerInfo;

public class CustomerInfoDAOImpl implements ICustomerInfoDAO {
	public boolean save(CustomerInfo customerInfo) {
		String sql = "insert into customerInfo(custName,pwd,email)" +
				"values('"+customerInfo.getCustName()+"','"+customerInfo.getPwd()+"','"+customerInfo.getEmail()+"')";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(CustomerInfo customerInfo) {
		String sql = "update customerInfo set custName = '"+customerInfo.getCustName()+"',pwd = '"+customerInfo.getPwd()+"',email = '"+customerInfo.getEmail()+"'where custId = '"+customerInfo.getCustId()+"' ";
		System.out.println(sql);
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql = "delete from customrInfo where custId = '"+id+"'"; 
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public CustomerInfo findById(int id) {
		CustomerInfo customerInfo = null;
		DBManager dbManager = new DBManager();
		String sql = "select custId,custName,pwd,email from CustomerInfo where custId = '"+id+"'";
		ResultSet rs = dbManager.query(sql);
			try {
				while (rs.next()) {
					customerInfo = new CustomerInfo(rs.getInt("custId"),
							rs.getString("custName"),
							rs.getString("pwd"),
							rs.getString("email"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				dbManager.close();
			}
			return customerInfo;
	}

	public List<CustomerInfo> findAll() {
		List<CustomerInfo> customerInfos = new Vector<CustomerInfo>();
		String sql = "select custId,custName,pwd,email from customerInfo";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				CustomerInfo customerInfo = new CustomerInfo(rs.getInt("custId"),
						rs.getString("custName"),
						rs.getString("pwd"),
						rs.getString("email"));
				customerInfos.add(customerInfo);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return customerInfos;
	}

	/**
	 * 判断用户名密码是否正确,如果正确返回该用户的详细信息,如果错误返回null
	 */
	public CustomerInfo findByNameAndPwd(String name, String pwd) {
		CustomerInfo customerInfo = null;
		DBManager dbManager = new DBManager();
		String sql = 
			"select custId,custName,pwd,email " +
				"from CustomerInfo " +
				"where " +
				"	custName = '" + name + "' " +
				"	and pwd = '" + pwd + "'";
		ResultSet rs = dbManager.query(sql);
			try {
				while (rs.next()) {
					customerInfo = new CustomerInfo(rs.getInt("custId"),
							rs.getString("custName"),
							rs.getString("pwd"),
							rs.getString("email"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				dbManager.close();
			}
		return customerInfo;

	}

}

