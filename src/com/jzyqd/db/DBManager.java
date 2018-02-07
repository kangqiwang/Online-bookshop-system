package com.jzyqd.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 通用数据库访问对象
 * @author wangwang
 *
 */
public class DBManager {
	private Connection con;
	private Statement  sta;
	private ResultSet  rs;
	
	public Connection getCon() {
		String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=jinzhiBook";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, "sa", "");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}
	/**
	 * 用来执行查询(select)语句
	 * @param sql 要执行的SQL语句
	 * @return 结果集
	 */
	public ResultSet query(String sql) {
		System.out.println(sql);
		String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=jinzhiBook";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, "sa", "");
			sta = con.createStatement();
			rs = sta.executeQuery(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * 用来执行insert,update,delete SQL语句
	 * @param sql 要执行的SQL语句
	 * @return sql语句影响的行数
	 */
	public int update(String sql) {
		System.out.println(sql);
		int rows = 0;
		String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=jinzhiBook";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, "sa", "");
			sta = con.createStatement();
			rows = sta.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return rows;
	}
	public int update(String sql, Connection mycon) {
		System.out.println(sql);
		int rows = 0;
		try {			
			sta = mycon.createStatement();
			rows = sta.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	/**
	 * 关闭资源
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (sta != null) {
				sta.close();
				sta = null;
			}	
			if (con != null) {
				con.close();
				con = null;
			}	
		} catch (Exception e) {
			System.out.println("关闭资源时发生异常");
		}
		
	}
}

