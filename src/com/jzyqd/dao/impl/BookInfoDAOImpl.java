package com.jzyqd.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.jzyqd.dao.IBookInfoDAO;
import com.jzyqd.db.DBManager;
import com.jzyqd.entity.BookInfo;
import com.jzyqd.tool.DateConvert;




public class BookInfoDAOImpl implements IBookInfoDAO
{
	public boolean save(BookInfo bookInfo) {
		String  pbdateStr = DateConvert.convertToString(bookInfo.getPbdate());
		String sql = 
			" insert into bookInfo" +
			"	(bookName,booktypeId,author,pbName,context, " +
			"	smallImg,bigImg,price,pbdate,hyprice, " +
			"	bookStates,sjdate,num,saleCount) " +
			"values" +
			"	('" + bookInfo.getBookName() + "'," + bookInfo.getBooktypeId() + ",'" + bookInfo.getAuthor() + "','" + bookInfo.getPbName() + "','" + bookInfo.getContext() + "'," +
			"	 '" + bookInfo.getSmallImg() + "','" + bookInfo.getBigImg() + "'," + bookInfo.getPrice() + ",'" + pbdateStr + "'," + bookInfo.getHyprice() + "," +
			"	" + bookInfo.getBookStates()+ ",null," + bookInfo.getNum() + ",0)";
		DBManager dbManager = new DBManager();
		int rows = dbManager.update(sql);
		return (rows == 1);
//		if (rows == 1) {
//			return true;
//		} else {
//			return false;	
//		}
		
	}
	
	public boolean delete(int id) {
		//ÎïÀíÉ¾³ý
		String sql = "delete from bookInfo where bookId = " + id;
		//Âß¼­É¾³ý 
		String sql2 = "update bookInfo set bookStates = 0 where bookId = " + id;
		DBManager dbManager = new DBManager();
		int rows = dbManager.update(sql2);
		return (rows == 1);
	}
	//{1, 2, 3}
	public List<BookInfo> findAll(int[] states) {
		List<BookInfo> bookInfos = new Vector<BookInfo>();
		String sql = 
			"select " +
			"	bookId, bookName,booktypeId,author,pbName,context, 	" +
			"	smallImg,bigImg,price,pbdate,hyprice, 	" +
			"	bookStates,sjdate,num,saleCount " +
			"from " +
			"	bookInfo " +
			"where " +
			"	bookStates in(";
		for (int i = 0; i < states.length; i++) {
			sql += states[i];
			if (i != states.length - 1) {
				sql += ",";	
			}
		}
		sql += ")";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				BookInfo bookInfo = new BookInfo(rs.getInt("bookId"), 
						rs.getString("bookName"), 
						rs.getInt("booktypeId"),
						rs.getString("author"), 
						rs.getString("pbName"), 
						rs.getString("context"), 
						rs.getString("smallImg"),
						rs.getString("bigImg"), 
						rs.getFloat("price"), 
						rs.getDate("pbdate"), 
						rs.getFloat("hyprice"), 
						rs.getInt("bookStates"), 
						rs.getDate("sjdate"), 
						rs.getInt("num"), 
						rs.getInt("saleCount"));
				bookInfos.add(bookInfo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookInfos;
	}

	public BookInfo findById(int id) {
		BookInfo bookInfo = null;
		String sql = 
			"select " +
			"	bookId, bookName,booktypeId,author,pbName,context, 	" +
			"	smallImg,bigImg,price,pbdate,hyprice, 	" +
			"	bookStates,sjdate,num,saleCount " +
			"from " +
			"	bookInfo " +
			"where " +
			"	bookId = " + id;
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				bookInfo = new BookInfo(rs.getInt("bookId"), 
						rs.getString("bookName"), 
						rs.getInt("booktypeId"),
						rs.getString("author"), 
						rs.getString("pbName"), 
						rs.getString("context"), 
						rs.getString("smallImg"),
						rs.getString("bigImg"), 
						rs.getFloat("price"), 
						rs.getDate("pbdate"), 
						rs.getFloat("hyprice"), 
						rs.getInt("bookStates"), 
						rs.getDate("sjdate"), 
						rs.getInt("num"), 
						rs.getInt("saleCount"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookInfo;
	}

	

	public boolean update(BookInfo bookInfo) {
		String sql = 
			"update bookInfo " +
			"set " +
			"	bookName = '" + bookInfo.getBookName() + "', " +
			"	bookTypeId = " + bookInfo.getBooktypeId() + ", " +
			"	author = '" + bookInfo.getAuthor()+ "' " +
			"where " +
			"	bookId = " + bookInfo.getBookId();
		DBManager dbManager = new DBManager();
		int rows = dbManager.update(sql);
		return (rows == 1);
	}

	public List<BookInfo> getNowPageDate(int pageSize, int nowPage) {
		String sql = 
			"select " +
			"	top " + pageSize  + " bookId, bookName,booktypeId,author,pbName,context, 	smallImg,bigImg,price,pbdate,hyprice, bookStates,sjdate,num,saleCount " +
			"from " +
			"	bookInfo " +
			"where " +
			"	bookId not in( " +
			"			select top " + (nowPage-1)*pageSize + " bookId from bookInfo)";
		List<BookInfo> bookInfos = new ArrayList<BookInfo>();
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				BookInfo bookInfo = new BookInfo(rs.getInt("bookId"), 
						rs.getString("bookName"), 
						rs.getInt("booktypeId"),
						rs.getString("author"), 
						rs.getString("pbName"), 
						rs.getString("context"), 
						rs.getString("smallImg"),
						rs.getString("bigImg"), 
						rs.getFloat("price"), 
						rs.getDate("pbdate"), 
						rs.getFloat("hyprice"), 
						rs.getInt("bookStates"), 
						rs.getDate("sjdate"), 
						rs.getInt("num"), 
						rs.getInt("saleCount"));
				bookInfos.add(bookInfo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookInfos;

	}

	public int getPageCount(int pageSize) {
		int rowCount = 0;
		int pageCount = 0;
		String sql = "select count(*) from bookInfo";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()) {
				rowCount = rs.getInt(1);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		pageCount = rowCount / pageSize;
		if (rowCount % pageSize != 0) {
			pageCount ++;
		}
		return pageCount;
	}

	public List<BookInfo> findAll() {
		List<BookInfo> bookInfos = new Vector<BookInfo>();
		String sql = 
			"select " +
			"	bookId, bookName,booktypeId,author,pbName,context, 	" +
			"	smallImg,bigImg,price,pbdate,hyprice, 	" +
			"	bookStates,sjdate,num,saleCount " +
			"from " +
			"	bookInfo order by bookId desc";
//			"where " +
//			"	bookStates = 2 ";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				BookInfo bookInfo = new BookInfo(rs.getInt("bookId"), 
						rs.getString("bookName"), 
						rs.getInt("booktypeId"),
						rs.getString("author"), 
						rs.getString("pbName"), 
						rs.getString("context"), 
						rs.getString("smallImg"),
						rs.getString("bigImg"), 
						rs.getFloat("price"), 
						rs.getDate("pbdate"), 
						rs.getFloat("hyprice"), 
						rs.getInt("bookStates"), 
						rs.getDate("sjdate"), 
						rs.getInt("num"), 
						rs.getInt("saleCount"));
				bookInfos.add(bookInfo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookInfos;


	}

	public List<BookInfo> findBySJDate(int row) {
		List<BookInfo> bookInfos = new Vector<BookInfo>();
		String sql = 
			"select top " + row +
			"	bookId, bookName,booktypeId,author,pbName,context, 	" +
			"	smallImg,bigImg,price,pbdate,hyprice, 	" +
			"	bookStates,sjdate,num,saleCount " +
			"from " +
			"	bookInfo " +
//			"where " +
//			"	bookStates = 2 " +
			"order by sjdate desc";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				BookInfo bookInfo = new BookInfo(rs.getInt("bookId"), 
						rs.getString("bookName"), 
						rs.getInt("booktypeId"),
						rs.getString("author"), 
						rs.getString("pbName"), 
						rs.getString("context"), 
						rs.getString("smallImg"),
						rs.getString("bigImg"), 
						rs.getFloat("price"), 
						rs.getDate("pbdate"), 
						rs.getFloat("hyprice"), 
						rs.getInt("bookStates"), 
						rs.getDate("sjdate"), 
						rs.getInt("num"), 
						rs.getInt("saleCount"));
				bookInfos.add(bookInfo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookInfos;

	}

	public List<BookInfo> findBySaleCount(int row) {
		List<BookInfo> bookInfos = new Vector<BookInfo>();
		String sql = 
			"select top " + row +
			"	bookId, bookName,booktypeId,author,pbName,context, 	" +
			"	smallImg,bigImg,price,pbdate,hyprice, 	" +
			"	bookStates,sjdate,num,saleCount " +
			"from " +
			"	bookInfo " +
//			"where " +
//			"	bookStates = 2 " +
			"order by saleCount desc";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				BookInfo bookInfo = new BookInfo(rs.getInt("bookId"), 
						rs.getString("bookName"), 
						rs.getInt("booktypeId"),
						rs.getString("author"), 
						rs.getString("pbName"), 
						rs.getString("context"), 
						rs.getString("smallImg"),
						rs.getString("bigImg"), 
						rs.getFloat("price"), 
						rs.getDate("pbdate"), 
						rs.getFloat("hyprice"), 
						rs.getInt("bookStates"), 
						rs.getDate("sjdate"), 
						rs.getInt("num"), 
						rs.getInt("saleCount"));
				bookInfos.add(bookInfo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookInfos;
	}

	public List<BookInfo> findByTypeId(int typeId) {
		List<BookInfo> bookInfos = new Vector<BookInfo>();
		String sql = 
			"select " +
			"	bookId, bookName,booktypeId,author,pbName,context, 	" +
			"	smallImg,bigImg,price,pbdate,hyprice, 	" +
			"	bookStates,sjdate,num,saleCount " +
			"from " +
			"	bookInfo " +
			"where " +
			"	bookTypeId = " + typeId;
//			
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				BookInfo bookInfo = new BookInfo(rs.getInt("bookId"), 
						rs.getString("bookName"), 
						rs.getInt("booktypeId"),
						rs.getString("author"), 
						rs.getString("pbName"), 
						rs.getString("context"), 
						rs.getString("smallImg"),
						rs.getString("bigImg"), 
						rs.getFloat("price"), 
						rs.getDate("pbdate"), 
						rs.getFloat("hyprice"), 
						rs.getInt("bookStates"), 
						rs.getDate("sjdate"), 
						rs.getInt("num"), 
						rs.getInt("saleCount"));
				bookInfos.add(bookInfo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookInfos;

	}

}
