package com.jzyqd.tool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {
	/**
	 * ��yyyy-MM-dd��ʽ���ַ���ת��Ϊ����
	 * @param dateStr
	 * @return
	 */
	public static Date convertToDate(String dateStr) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * ���û�ָ����ʽ���ַ���ת��Ϊ����
	 * @param dateStr
	 * @param pt
	 * @return
	 */
	public static Date convertToDate(String dateStr, String pt) {
		DateFormat df = new SimpleDateFormat(pt);
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * ������ת��Ϊyyyy-MM-dd��ʽ���ַ���
	 * @param date
	 * @return
	 */
	public static String convertToString(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = df.format(date);
		return dateStr;
	}
	
	/**
	 * ������ת��Ϊָ����ʽ���ַ���
	 * @param date
	 * @return
	 */
	public static String convertToString(Date date, String pt) {
		DateFormat df = new SimpleDateFormat(pt);
		String dateStr = df.format(date);
		return dateStr;
	}
	
	public static void main(String[] args) {
		String str1 = "1999-9-9";
		String str2 = "9-9-1999";
		System.out.println(DateConvert.convertToDate(str1));
		System.out.println(DateConvert.convertToDate(str2, "MM-dd-yyyy"));
		
		
	}
}
