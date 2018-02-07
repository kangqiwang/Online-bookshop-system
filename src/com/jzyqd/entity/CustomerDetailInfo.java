package com.jzyqd.entity;

public class CustomerDetailInfo {

	private int custId;	//���
	private String tel;	//��ϵ�绰
	private String address;//��ַ
	private String sex;//�Ա�
	private int age;//����
	private double countMoney;//�ۼ����ѽ��
	private int Qq;//QQ����
	
	
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
