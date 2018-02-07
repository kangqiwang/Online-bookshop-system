package com.jzyqd.entity;

public class SysAdmin {

	private int adminId;//管理员编号
	private String adminName;//管理员姓名
	private String pwd;//管理员密码
	private int adminType;//管理员级别
	
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
