package com.jzyqd.dao;

import java.util.List;

import com.jzyqd.entity.BookInfo;

public interface IBookInfoDAO {

	public abstract boolean save(BookInfo bookInfo);

	public abstract boolean update(BookInfo bookInfo);

	public abstract boolean delete(int id);

	public abstract BookInfo findById(int id);

	public abstract List<BookInfo> findAll();
	public abstract List<BookInfo> findByTypeId(int typeId);
	
	public abstract List<BookInfo> findBySJDate(int row);
	public abstract List<BookInfo> findBySaleCount(int row);
	
	

}



