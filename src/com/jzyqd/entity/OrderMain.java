package com.jzyqd.entity;

public class OrderMain {

	private String orderNum;//������� 
	private int customerId;//�ͻ���� 
	private String customerName;//�ջ�������		
	private String tel;//�ջ��˵绰		
	private String address;//�ջ���ַ	
	private String status;//���۵�״̬��0-δ����1-�Ѵ���2-�Է�����3-���ջ���
	private int adminId;//�����˱��
	private String context;//��ע
	private float sumprice;
	public OrderMain() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderMain(int customerId, String customerName, String tel,
			String address, String status, int adminId, String context,
			float sumprice) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.tel = tel;
		this.address = address;
		this.status = status;
		this.adminId = adminId;
		this.context = context;
		this.sumprice = sumprice;
	}
	public OrderMain(String orderNum, int customerId, String customerName,
			String tel, String address,  
			String context, float sumprice) {
		super();
		this.orderNum = orderNum;
		this.customerId = customerId;
		this.customerName = customerName;
		this.tel = tel;
		this.address = address;
		this.status = status;
		this.adminId = adminId;
		this.context = context;
		this.sumprice = sumprice;
	}
	public OrderMain(String orderNum, int customerId, String customerName,
			String tel, String address, String status, int adminId,
			String context, float sumprice) {
		super();
		this.orderNum = orderNum;
		this.customerId = customerId;
		this.customerName = customerName;
		this.tel = tel;
		this.address = address;
		this.status = status;
		this.adminId = adminId;
		this.context = context;
		this.sumprice = sumprice;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public float getSumprice() {
		return sumprice;
	}
	public void setSumprice(float sumprice) {
		this.sumprice = sumprice;
	}
	
	
}
