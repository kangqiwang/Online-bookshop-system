package com.jzyqd.entity;

import java.util.Date;

public class Favorite {

	private int favoriteId;//�ղؼк�
	private int bookId;//ͼ����
	private int custId;//�û����
	private Date date;//�ղ�ʱ��
	private String context;//��ע
	
	
	public Favorite(int favoriteId,int bookId,int custId,Date date,String context) {
		super();
		this.favoriteId = favoriteId;
		this.bookId = bookId;
		this.custId = custId;
		this.date = date;
		this.context = context;	
	}


	public int getFavoriteId() {
		return favoriteId;
	}


	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getContext() {
		return context;
	}


	public void setContext(String context) {
		this.context = context;
	}


	@Override
	public String toString() {
		return "Favorite [favoriteId=" + favoriteId + ", bookId=" + bookId
				+ ", custId=" + custId + ", date=" + date + ", context="
				+ context + "]";
	}
	
	
}
