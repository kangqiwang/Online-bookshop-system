package com.jzyqd.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.jzyqd.dao.IBookDiscussDAO;
import com.jzyqd.db.DBManager;
import com.jzyqd.entity.BookDiscuss;

public class BookDiscussDAOImpl implements IBookDiscussDAO{

	public boolean save(BookDiscuss bookDiscuss) {
		String sql = "insert into bookDiscuss(context,states)values('"+bookDiscuss.getContext()+"','"+bookDiscuss.getStates()+"')";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(BookDiscuss bookDiscuss) {
		String sql = "update bookDiscuss set (context,states) where '"+bookDiscuss+"'";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql = "delete from bookDiscuss where '"+id+"'";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public BookDiscuss findById(int id) {
		BookDiscuss bookDiscusss = null;
		DBManager dbManager = new DBManager();
		String sql = "selete disId,bookId,custId,context,states from bookDiscuss where '"+id+"'";
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				bookDiscusss = new BookDiscuss(rs.getInt("disId"),
						rs.getInt("bookId"),
						rs.getInt("custId"),
						rs.getString("context"),
						rs.getString("states"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return bookDiscusss;
		
	}

	public List<BookDiscuss> findAll() {
		List<BookDiscuss> bookDiscusss = new Vector<BookDiscuss>();
		String sql = "selete disId,bookId,custId,context,states from bookDiscuss where bookDiscusss";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while(rs.next()){
				BookDiscuss bookDiscuss = new BookDiscuss(rs.getInt("disId"),
							rs.getInt("bookId"),
							rs.getInt("custId"),
							rs.getString("context"),
							rs.getString("states"));
				bookDiscusss.add(bookDiscuss);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookDiscusss;
	}

	public List<BookDiscuss> findByBookId(int bookId) {
			List<BookDiscuss> bookDiscusss = new Vector<BookDiscuss>();
			String sql = 
				"select " +
				"	disId,bookId,custId,context,states " +
				"from " +
				"	bookDiscuss " +
				"where  " +
				"	states = 1 and bookId = " + bookId;
			DBManager dbManager = new DBManager();
			ResultSet rs = dbManager.query(sql);
			try {
				while(rs.next()){
					BookDiscuss bookDiscuss = new BookDiscuss(rs.getInt("disId"),
								rs.getInt("bookId"),
								rs.getInt("custId"),
								rs.getString("context"),
								rs.getString("states"));
					bookDiscusss.add(bookDiscuss);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bookDiscusss;
		}



}
