package com.jzyqd.dao;

import java.util.List;

import com.jzyqd.entity.BookDiscuss;

public interface IBookDiscussDAO {
	public boolean save(BookDiscuss bookDiscuss);
	public boolean update(BookDiscuss bookDiscuss);
	public boolean delete(int id);
	public BookDiscuss findById(int id);
	public List<BookDiscuss> findAll();
	
	public List<BookDiscuss> findByBookId(int bookId);
}
