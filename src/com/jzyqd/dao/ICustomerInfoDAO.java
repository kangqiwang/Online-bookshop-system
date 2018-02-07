package com.jzyqd.dao;

import java.util.List;

import com.jzyqd.entity.CustomerInfo;

public interface ICustomerInfoDAO {

	public boolean save(CustomerInfo customerInfo);
	public boolean update(CustomerInfo CustomerInfo);
	public boolean delete(int id);
	public CustomerInfo findById(int id);
	public List<CustomerInfo> findAll();
	
	public CustomerInfo findByNameAndPwd(String name, String pwd);
}
