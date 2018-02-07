package com.jzyqd.entity;

public class CustomerDetailInfo {

	private int custId;	//编号
	private String tel;	//联系电话
	private String address;//地址
	private String sex;//性别
	private int age;//年龄
	private double countMoney;//累计消费金额
	private int Qq;//QQ号码
	
	
	public CustomerDetailInfo(int custId,String tel,String address,String sex,int age,double countMoney,int Qq) {
		super();
		this.custId = custId;
		this.tel = tel;
		this.address = address;
		this.sex = sex;
		this.age = age;
		this.countMoney = countMoney;
		this.Qq = Qq;		
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getCountMoney() {
		return countMoney;
	}
	public void setCountMoney(double countMoney) {
		this.countMoney = countMoney;
	}
	public int getQq() {
		return Qq;
	}
	public void setQq(int qq) {
		Qq = qq;
	}
	@Override
	public String toString() {
		return "CustomerDetailInfo [custId=" + custId + ", tel=" + tel
				+ ", address=" + address + ", sex=" + sex + ", age=" + age
				+ ", countMoney=" + countMoney + ", Qq=" + Qq + "]";
	}
	
	
	
}
