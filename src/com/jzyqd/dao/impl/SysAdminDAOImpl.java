package com.jzyqd.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.jzyqd.dao.ISysAdminDAO;
import com.jzyqd.db.DBManager;
import com.jzyqd.entity.SysAdmin;

public class SysAdminDAOImpl implements ISysAdminDAO{

	public boolean save(SysAdmin sysAdmin) {
		String sql = "insert into sysAdmin(adminName,pwd,adminType)" +
				"values('"+sysAdmin.getAdminName()+"','"+sysAdmin.getPwd()+"','"+sysAdmin.getAdminType()+"')";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean delete(int id) {
		String sql = "delete from sysAdmin where '"+id+"'";
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public boolean update(SysAdmin sysAdmin) {
		String sql = "update sysAdmin set('"+sysAdmin.getAdminName()+"','"+sysAdmin.getPwd()+"','"+sysAdmin.getAdminType()+"') where '"+sysAdmin+"'";
		System.out.println(sql);
		DBManager dbManager = new DBManager();
		return (dbManager.update(sql) == 1);
	}

	public SysAdmin findById(int id) {
		SysAdmin sysAdmin = null;
		DBManager dbManager = new DBManager();
		String sql = "select adminId,adminName,pwd,adminType from sysAdmin where adminId = '"+id+"'";
		ResultSet rs = dbManager.query(sql);
			try {
				while (rs.next()) {
					sysAdmin = new SysAdmin(rs.getInt("adminId"),
							rs.getString("adminName"),
							rs.getString("pwd"),
							rs.getShort("adminType"));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				dbManager.close();
			}
			return sysAdmin;
	}

	public List<SysAdmin> findAll() {
		List<SysAdmin> sysAdmins = new Vector<SysAdmin>();
		String sql = "select adminId,adminName,pwd,adminType from sysAdmin where customerInfo";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			while (rs.next()) {
				SysAdmin sysAdmin = new SysAdmin(rs.getInt("adminId"),
						rs.getString("adminName"),
						rs.getString("pwd"),
						rs.getShort("adminType"));
				sysAdmins.add(sysAdmin);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return sysAdmins;
	}
	
	/**
	 * 根据用户名与密码找到相关信息
	 * @param name
	 * @param pwd
	 * @return 如果找到,返回该实体类的所有信息,如果没找到,返回null
	 */
	public SysAdmin findByNameAndPwd(String name, String pwd) {
		SysAdmin sysAdmin = null;
		String sql = "select " +
				"adminId, adminType from sysAdmin where adminName='" + name + "' and pwd = '" + pwd + "'";
		DBManager dbManager = new DBManager();
		ResultSet rs = dbManager.query(sql);
		try {
			if (rs.next()) {
					sysAdmin = new SysAdmin(rs.getInt("adminId"),
						name,
						pwd,
						rs.getShort("adminType"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return sysAdmin;
	}

}
