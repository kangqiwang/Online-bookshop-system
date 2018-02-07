package com.jzyqd.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.jzyqd.dao.IBookTypeDAO;
import com.jzyqd.db.DBManager;
import com.jzyqd.entity.BookType;


public class BookTypeDAOImpl implements IBookTypeDAO {

	public boolean save(BookType bookType) {
		
		String sql = "insert into bookType(parentId,bookTypeName,context,isDelete)" +
				"values("+bookType.getParentId()+"," +
						"'"+bookType.getBookTypeName()+"'," +
						"'"+bookType.getContext()+"'," +
						""+bookType.getIsDelete()+")"; 
		System.out.println(sql);
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(BookType bookType) {
		String sql = 
			"update bookType " +
			"set " +
			"    parentId = " + bookType.getParentId()+ "," +
			"	 bookTypeName = '" + bookType.getBookTypeName()+ "'," +
			"	 context = '" + bookType.getContext()+ "'," +
			"	 isDelete = " + bookType.getIsDelete() +
			" where" +
			"   bookTypeId = "+bookType.getBookTypeId()+"";
		DBManager dbManager = new DBManager();
			return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql2 = "update bookType set isDelete = 0 where bookTypeId = " + id;
		String sql = "delete from bookType where bookTypeId = " + id;
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public BookType findById(int id) {
		BookType bookType = null;
		DBManager dbManager = new DBManager();
		String sql = "select * from bookType where bookTypeId = '"+id+"'";
		ResultSet rs = dbManager.query(sql);
			try {
				while (rs.next()) {
					bookType = new BookType(rs.getInt("bookTypeId"),
							rs.getInt("parentId"),
							rs.getString("bookTypeName"),
							rs.getString("context"),
							rs.getInt("isDelete"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				dbManager.close();
			}
			return bookType;
	}

	public List<BookType> findAll() {
		
		String sql = "select bookTypeId,parentId,bookTypeName,context,isDelete from bookType";
		List<BookType> bookTypes = new Vector<BookType>();
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				BookType bookType = new BookType(rs.getInt("bookTypeId"),
						rs.getInt("parentId"),
						rs.getString("bookTypeName"),
						rs.getString("context"),
						rs.getInt("isDelete"));
				bookTypes.add(bookType);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookTypes;
	}

	public int getPageCount(int pageSize) {
		int rowCount = 0;
		int pageCount = 0;
		String sql = "select count(*) from bookType";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				rowCount = rs.getInt(1);
			}
			pageCount = rowCount / pageSize;
			if (rowCount % pageSize != 0) {
				pageCount ++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageCount;
	}

	public List<BookType> getNowPageData(int pageSize, int nowPage) {
		String sql = 
			"select top " + pageSize + 
			"	bookTypeId,parentId,bookTypeName,context,isDelete " +
			"from bookType " +
			"where " +
			"	bookTypeId not in (" +
			"		select top " + (nowPage-1)*pageSize + " bookTypeId from bookType)";
		System.out.println(sql);
		List<BookType> bookTypes = new Vector<BookType>();
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				BookType bookType = new BookType(rs.getInt("bookTypeId"),
						rs.getInt("parentId"),
						rs.getString("bookTypeName"),
						rs.getString("context"),
						rs.getInt("isDelete"));
				bookTypes.add(bookType);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookTypes;

	}

	public List<BookType> findByParentId(int parentId) {

		String sql = "select bookTypeId,parentId,bookTypeName,context,isDelete from bookType where parentId = " + parentId;
		List<BookType> bookTypes = new Vector<BookType>();
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				BookType bookType = new BookType(rs.getInt("bookTypeId"),
						rs.getInt("parentId"),
						rs.getString("bookTypeName"),
						rs.getString("context"),
						rs.getInt("isDelete"));
				bookTypes.add(bookType);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookTypes;
	}

	

}
