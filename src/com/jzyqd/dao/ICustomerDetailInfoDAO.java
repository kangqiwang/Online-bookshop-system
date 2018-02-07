package com.jzyqd.dao;

import java.sql.Connection;
import java.util.List;

import com.jzyqd.entity.CustomerDetailInfo;

public interface ICustomerDetailInfoDAO {

	public boolean save(CustomerDetailInfo customerDetailInfo);
	public boolean update(CustomerDetailInfo customerDetailInfo);
	public boolean delete(int id);
	public CustomerDetailInfo findById(int id);
	public List<CustomerDetailInfo>findAll();
	
	public boolean updateCountMoney(int id, double money);
	public boolean updateCountMoney(Connection con, int id, double money);
}
