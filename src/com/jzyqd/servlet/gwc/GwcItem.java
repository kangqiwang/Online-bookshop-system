package com.jzyqd.servlet.gwc;

import java.util.Date;

/**
 * ��ʾ���ﳵ�е�һ����Ʒ
 * @author wang
 *
 */
public class GwcItem {
	
	private int bookId;//ͼ����
    private String bookName;//ͼ������
    private String smallImg;//ͼ��ͼƬ    
	private float price;//�۸�
	private float hyprice;//��Ա��
	private int num;//��������
	
	public GwcItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GwcItem(int bookId, String bookName, String smallImg, float price,
			float hyprice, int num) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.smallImg = smallImg;
		this.price = price;
		this.hyprice = hyprice;
		this.num = num;
	}

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getSmallImg() {
		return smallImg;
	}
	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getHyprice() {
		return hyprice;
	}
	public void setHyprice(float hyprice) {
		this.hyprice = hyprice;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
