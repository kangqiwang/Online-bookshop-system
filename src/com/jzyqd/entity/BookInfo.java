package com.jzyqd.entity;

import java.util.Date;

public class BookInfo {
	private int bookId;//ͼ����
    private String bookName;//ͼ������
    private int booktypeId;//ͼ�������
	private String author;//����
	private String pbName;//����������
	private String context;//ͼ�����
	private String smallImg;//ͼ��ͼƬ
	private String bigImg;//ͼ��ͼƬ
	private float price;//�۸�
	private Date pbdate;//��������
	private float hyprice;//��Ա��
	private int bookStates;//ͼ��״̬ 0������  1δ�ϼ�  2�ϼ�  3 ȱ��
	private Date sjdate;//�ϼ�����
	private int num;//�����
	private int saleCount;//�ۻ�������
	public BookInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookInfo(String bookName, int booktypeId, String author,
			String pbName, String context, String smallImg, String bigImg,
			float price, Date pbdate, float hyprice, int bookStates,
			Date sjdate, int num, int saleCount) {
		super();

		this.bookName = bookName;
		this.booktypeId = booktypeId;
		this.author = author;
		this.pbName = pbName;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbdate = pbdate;
		this.hyprice = hyprice;
		this.bookStates = bookStates;
		this.sjdate = sjdate;
		this.num = num;
		this.saleCount = saleCount;
	}
	public BookInfo(int bookId, String bookName, int booktypeId, String author,
			String pbName, String context, String smallImg, String bigImg,
			float price, Date pbdate, float hyprice, int bookStates,
			Date sjdate, int num, int saleCount) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.booktypeId = booktypeId;
		this.author = author;
		this.pbName = pbName;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbdate = pbdate;
		this.hyprice = hyprice;
		this.bookStates = bookStates;
		this.sjdate = sjdate;
		this.num = num;
		this.saleCount = saleCount;
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
	public int getBooktypeId() {
		return booktypeId;
	}
	public void setBooktypeId(int booktypeId) {
		this.booktypeId = booktypeId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPbName() {
		return pbName;
	}
	public void setPbName(String pbName) {
		this.pbName = pbName;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getSmallImg() {
		return smallImg;
	}
	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}
	public String getBigImg() {
		return bigImg;
	}
	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getPbdate() {
		return pbdate;
	}
	public void setPbdate(Date pbdate) {
		this.pbdate = pbdate;
	}
	public float getHyprice() {
		return hyprice;
	}
	public void setHyprice(float hyprice) {
		this.hyprice = hyprice;
	}
	public int getBookStates() {
		return bookStates;
	}
	public void setBookStates(int bookStates) {
		this.bookStates = bookStates;
	}
	public Date getSjdate() {
		return sjdate;
	}
	public void setSjdate(Date sjdate) {
		this.sjdate = sjdate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bigImg == null) ? 0 : bigImg.hashCode());
		result = prime * result + bookId;
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + bookStates;
		result = prime * result + booktypeId;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + Float.floatToIntBits(hyprice);
		result = prime * result + num;
		result = prime * result + ((pbName == null) ? 0 : pbName.hashCode());
		result = prime * result + ((pbdate == null) ? 0 : pbdate.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + saleCount;
		result = prime * result + ((sjdate == null) ? 0 : sjdate.hashCode());
		result = prime * result
				+ ((smallImg == null) ? 0 : smallImg.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookInfo other = (BookInfo) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bigImg == null) {
			if (other.bigImg != null)
				return false;
		} else if (!bigImg.equals(other.bigImg))
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookStates != other.bookStates)
			return false;
		if (booktypeId != other.booktypeId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (Float.floatToIntBits(hyprice) != Float
				.floatToIntBits(other.hyprice))
			return false;
		if (num != other.num)
			return false;
		if (pbName == null) {
			if (other.pbName != null)
				return false;
		} else if (!pbName.equals(other.pbName))
			return false;
		if (pbdate == null) {
			if (other.pbdate != null)
				return false;
		} else if (!pbdate.equals(other.pbdate))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (saleCount != other.saleCount)
			return false;
		if (sjdate == null) {
			if (other.sjdate != null)
				return false;
		} else if (!sjdate.equals(other.sjdate))
			return false;
		if (smallImg == null) {
			if (other.smallImg != null)
				return false;
		} else if (!smallImg.equals(other.smallImg))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BookInfo [author=" + author + ", bigImg=" + bigImg
				+ ", bookId=" + bookId + ", bookName=" + bookName
				+ ", bookStates=" + bookStates + ", booktypeId=" + booktypeId
				+ ", context=" + context + ", hyprice=" + hyprice + ", num="
				+ num + ", pbName=" + pbName + ", pbdate=" + pbdate
				+ ", price=" + price + ", saleCount=" + saleCount + ", sjdate="
				+ sjdate + ", smallImg=" + smallImg + "]";
	}
	
}
