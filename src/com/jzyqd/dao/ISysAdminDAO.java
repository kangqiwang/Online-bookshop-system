package com.jzyqd.dao;

import java.util.List;

import com.jzyqd.entity.SysAdmin;

public interface ISysAdminDAO {
	public boolean save(SysAdmin sysAdmin);
	public boolean delete(int id);
	public boolean update(SysAdmin sysAdmin);
	public SysAdmin findById(int id);
	public List<SysAdmin> findAll();
	/**
	 * 根据用户名与密码找到相关信息
	 * @param name
	 * @param pwd
	 * @return 如果找到,返回该实体类的所有信息,如果没找到,返回null
	 */
	public SysAdmin findByNameAndPwd(String name, String pwd);
	
}
