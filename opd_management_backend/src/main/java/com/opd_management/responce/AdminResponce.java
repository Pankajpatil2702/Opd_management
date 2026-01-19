package com.opd_management.responce;

public class AdminResponce {

	private int id;
	private String name;
	private String email;
	private String mobileNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public AdminResponce(int id, String name, String email, String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
	}
	public AdminResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AdminResponce [id=" + id + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}
	
	
}
