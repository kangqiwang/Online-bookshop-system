package com.jzyqd.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jzyqd.dao.IEmployeeDAO;
import com.jzyqd.dao.impl.EmployeeDAOImpl;
import com.jzyqd.entity.Employee;
import com.jzyqd.tool.DateConvert;

public class TestEmployeeDAO {
	public static void main(String[] args) {
		//testSave();
		//testDelete();
		testFindAll();
		//testFindById();
		//testUpdate();
	}
	public static void testFindById() {
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		Employee employee = employeeDAO.findById(1);
		System.out.println(employee);
	}
	public static void testFindAll() {
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		List<Employee> emps = employeeDAO.getNowPageData(2, 3);
		for (Employee employee : emps) {
			System.out.println(employee);
		}
	}
	public static void testDelete() {
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		System.out.println(employeeDAO.delete(5));
	}
	public static void testSave() {
		Employee employee = new Employee();
		employee.setEmpName("超哥2dai");
		employee.setEmpAge(22);
		//关于日期的处理
		//1992-2-14 在界面上输入日期,程序中得到的是字符串
		//需要把字符串转换为日期
		String btdStr = "1992-2-14";
		Date btd = DateConvert.convertToDate(btdStr);
		/************把字符串转换为日期**************/
		/*DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date btd = null;
		try {
			btd = df.parse(btdStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/**************************/
		employee.setEmpBtd(btd);
		employee.setEmpSex(1);
		employee.setIsDelete(1);
		
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		if (employeeDAO.save(employee)) {
			System.out.println("新增成功 ");
		} else {
			System.out.println("新增失败");
		}
		
		
	}
	public static void testUpdate() {
		Employee employee = new Employee();
		employee.setEmpId(1);
		employee.setEmpName("超爷");
		employee.setEmpAge(22);
		String btdStr = "1972-2-14";
		Date btd = DateConvert.convertToDate(btdStr);
		employee.setEmpBtd(btd);
		employee.setEmpSex(1);
		employee.setIsDelete(1);
		
		IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
		if (employeeDAO.update(employee)) {
			System.out.println("修改成功 ");
		} else {
			System.out.println("修改失败");
		}
		
		
	}

}
