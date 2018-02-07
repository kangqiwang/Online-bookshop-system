package com.jzyqd.dao;

import java.util.List;

import com.jzyqd.entity.BookType;

public interface IBookTypeDAO {

	public abstract boolean save(BookType bookType);

	public abstract boolean update(BookType bookType);

	public abstract boolean delete(int id);

	public abstract BookType findById(int id);
	
	
	public abstract List<BookType> findAll();
	public abstract List<BookType> findByParentId(int parentId);
	
	//�õ���ҳ��
	public int getPageCount(int pageSize);
	//�õ���ǰҳ������
	public abstract List<BookType> getNowPageData(int pageSize, int nowPage);
	
	

}