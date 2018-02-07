package com.jzyqd.entity;

public class OrderMain {

	private String orderNum;//订单编号 
	private int customerId;//客户编号 
	private String customerName;//收货人姓名		
	private String tel;//收货人电话		
	private String address;//收货地址	
	private String status;//销售单状态（0-未处理，1-已处理，2-以发货，3-已收货）
	private int adminId;//处理人编号
	private String context;//备注
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
