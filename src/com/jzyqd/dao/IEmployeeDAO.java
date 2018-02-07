package com.jzyqd.dao;

import java.util.List;

import com.jzyqd.entity.Employee;

public interface IEmployeeDAO {
	//�õ���ҳ��
	public int getPageCount(int pageSize);
	//�õ���ǰҳ�ľ�������
	public List<Employee> getNowPageData(int nowPage, int pageSize);
	
	public boolean save(Employee employee);
	public boolean update(Employee employee);
	public boolean delete(int id);
	public Employee findById(int id);
	public List<Employee> findAll();
	
	
}
