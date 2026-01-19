package com.opd_management.responce;

public class ReceptionResponce {

	private int id;
	private String name;
	private String email;
	private String mobile_no;
	private String shift;
	private int doctorid;
	
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
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	public ReceptionResponce(int id, String name, String email, String mobile_no, String shift, int doctorid) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile_no = mobile_no;
		this.shift = shift;
		this.doctorid = doctorid;
	}
	public ReceptionResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReceptionResponce [id=" + id + ", name=" + name + ", email=" + email + ", mobile_no=" + mobile_no
				+ ", shift=" + shift + ", doctorid=" + doctorid + "]";
	}
	
	
	
}
