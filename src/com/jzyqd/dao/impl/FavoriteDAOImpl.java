package com.jzyqd.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.jzyqd.dao.IFavoriteDAO;
import com.jzyqd.db.DBManager;
import com.jzyqd.entity.Favorite;

public class FavoriteDAOImpl implements IFavoriteDAO{

	public boolean save(Favorite favorite) {
		String sql = "insert into favorite(date,context)" +
				"values('"+favorite.getDate()+"','"+favorite.getContext()+"')";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql = "delete from favorite where '"+id+"'";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(Favorite favorite) {
		String sql = "update favorite set ('"+favorite.getDate()+"','"+favorite.getContext()+"')";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public Favorite findById(int id) {
		Favorite favorite = null;
		DBManager dbManager = new DBManager();
		String sql = "select favoriteId,bookId,custId,date,context from favorite where favoriteId = '"+id+"'";
		ResultSet rs = dbManager.query(sql);
			try {
				while (rs.next()) {
					favorite = new Favorite(rs.getInt("favoriteId"),
							rs.getInt("bookId"),
							rs.getInt("custId"),
							rs.getDate("date"),
							rs.getString("context"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				dbManager.close();
			}
			return favorite;
	}

	public List<Favorite> findAll() {
		List<Favorite> favorites = new Vector<Favorite>();
		String sql = "select favoriteId,bookId,custId,date,context from favorite where Favorite";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				Favorite favorite = new Favorite(rs.getInt("favoriteId"),
						rs.getInt("bookId"),
						rs.getInt("custId"),
						rs.getDate("date"),
						rs.getString("context"));
				favorites.add(favorite);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return favorites;
	}

}
