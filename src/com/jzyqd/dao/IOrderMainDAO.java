package com.jzyqd.dao;

import java.sql.Connection;
import java.util.List;

import com.jzyqd.entity.OrderMain;

public interface IOrderMainDAO {
	public boolean save(Connection con, OrderMain orderMain);
	
	public boolean save(OrderMain orderMain);
	public boolean delete(int id);
	public boolean update(OrderMain orderMain);
	public OrderMain findById(int id);
	public List<OrderMain> findAll();
}
