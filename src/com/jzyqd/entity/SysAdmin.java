package com.jzyqd.entity;

public class SysAdmin {

	private int adminId;//����Ա���
	private String adminName;//����Ա����
	private String pwd;//����Ա����
	private int adminType;//����Ա����
	
	public SysAdmin(int adminId,String adminName,String pwd,int adminType) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.pwd = pwd;
		this.adminType = adminType;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAdminType() {
		return adminType;
	}

	public void setAdminType(int adminType) {
		this.adminType = adminType;
	}

	@Override
	public String toString() {
		return "SysAdmin [adminId=" + adminId + ", adminName=" + adminName
				+ ", pwd=" + pwd + ", adminType=" + adminType + "]";
	}
	
	
	
}
