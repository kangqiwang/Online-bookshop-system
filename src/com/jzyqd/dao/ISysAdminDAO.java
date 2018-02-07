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
	 * �����û����������ҵ������Ϣ
	 * @param name
	 * @param pwd
	 * @return ����ҵ�,���ظ�ʵ�����������Ϣ,���û�ҵ�,����null
	 */
	public SysAdmin findByNameAndPwd(String name, String pwd);
	
}
