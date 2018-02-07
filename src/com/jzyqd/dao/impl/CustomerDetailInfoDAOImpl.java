package com.jzyqd.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.jzyqd.dao.ICustomerDetailInfoDAO;
import com.jzyqd.db.DBManager;
import com.jzyqd.entity.CustomerDetailInfo;

public class CustomerDetailInfoDAOImpl implements ICustomerDetailInfoDAO{

	public boolean save(CustomerDetailInfo customerDetailInfo) {
		String sql = "insert into customrInfo(tel,address,sex,age,countMoney,Qq)" +
				"values('"+customerDetailInfo.getTel()+"','"+customerDetailInfo.getAddress()+"','"+customerDetailInfo.getSex()+"','"+customerDetailInfo.getAge()+"','"+customerDetailInfo.getCountMoney()+"','"+customerDetailInfo.getQq()+"')";
	DBManager dbManager = new DBManager();
	return (dbManager.update(sql) == 1);
	}

	public boolean update(CustomerDetailInfo customerDetailInfo) {
		String sql = "update customerDetailInfo set tel = '"+customerDetailInfo.getTel()+"',address = '"+customerDetailInfo.getAddress()+"', sex = '"+customerDetailInfo.getSex()+"',age = '"+customerDetailInfo.getAge()+"',countMoney = '"+customerDetailInfo.getCountMoney()+"',Qq = '"+customerDetailInfo.getQq()+"'where custId = '"+customerDetailInfo.getCustId()+"' ";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql = "delete from customerDetailInfo where custid = '"+id+"'";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public CustomerDetailInfo findById(int id) {
		CustomerDetailInfo customerDetailInfo = null;
		DBManager dbManager = new DBManager();
		String sql = "select * from customerDetailInfo where custid = '"+id+"'";
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()){
				customerDetailInfo = new CustomerDetailInfo(rs.getInt("custId"),
						rs.getString("tel"),
						rs.getString("address"),
						rs.getString("sex"),
						rs.getInt("age"),
						rs.getFloat("countMoney"),
						rs.getInt("Qq"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerDetailInfo;
	}

	public List<CustomerDetailInfo> findAll() {
		List<CustomerDetailInfo> customerDetailInfos = new Vector<CustomerDetailInfo>();
		String sql = "select tel,address,sex,age,countMoney,Qq from customerDetailInfo";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				CustomerDetailInfo customerDetailInfo = new CustomerDetailInfo(rs.getInt("custId"),
						rs.getString("tel"),
						rs.getString("address"),
						rs.getString("sex"),
						rs.getInt("age"),
						rs.getFloat("countMoney"),
						rs.getInt("Qq"));	
				customerDetailInfos.add(customerDetailInfo);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return customerDetailInfos;
	}

	public boolean updateCountMoney(int id, double money) {
		String sql = 
			"update customerDetailInfo " +
			"	set  countMoney = countMoney + " + money + " " +
			"where custId = " + id;
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
		
	}
	public boolean updateCountMoney(Connection con, int id, double money) {
		String sql = 
			"update customerDetailInfo " +
			"	set  countMoney = countMoney + " +money  + " " +
			"where custId = " + id;
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
		
	}

}
