package com.jzyqd.dao;

import java.sql.Connection;
import java.util.List;

import com.jzyqd.entity.OrderDetail;

public interface IOrderDetailDAO {
	public boolean save(OrderDetail orderDetail);
	
	public boolean save(List<OrderDetail> orderDetails);
	
	public boolean save(Connection con, List<OrderDetail> orderDetails);
	
	public boolean delete(int id);
	public boolean update(OrderDetail orderDetail);
	public OrderDetail findById(int id);
	public List<OrderDetail> findAll();
	
	
	
}
