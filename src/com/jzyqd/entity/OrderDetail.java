package com.jzyqd.entity;

public class OrderDetail {

	private int detail;//明细编号 
	private String orderNum;//主表ID
	private int  bookId;//商品编号
	private int num;//订购数量
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(int detail, String orderNum, int bookId, int num) {
		super();
		this.detail = detail;
		this.orderNum = orderNum;
		this.bookId = bookId;
		this.num = num;
	}
	public OrderDetail(String orderNum, int bookId, int num) {
		super();
		this.orderNum = orderNum;
		this.bookId = bookId;
		this.num = num;
	}
	public int getDetail() {
		return detail;
	}
	public void setDetail(int detail) {
		this.detail = detail;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
