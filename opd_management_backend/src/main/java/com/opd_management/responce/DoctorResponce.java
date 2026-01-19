package com.opd_management.responce;

public class DoctorResponce {

	private int id;
	private String name;
	private String email;
	private String qualification;
	private String specialization;
	private String clinic_name;
	private String address;
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
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getClinic_name() {
		return clinic_name;
	}
	public void setClinic_name(String clinic_name) {
		this.clinic_name = clinic_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public DoctorResponce(int id, String name, String email, String qualification, String specialization,
			String clinic_name, String address, String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.qualification = qualification;
		this.specialization = specialization;
		this.clinic_name = clinic_name;
		this.address = address;
		this.mobileNo = mobileNo;
	}
	public DoctorResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DoctorResponce [id=" + id + ", name=" + name + ", email=" + email + ", qualification=" + qualification
				+ ", specialization=" + specialization + ", clinic_name=" + clinic_name + ", address=" + address
				+ ", mobileNo=" + mobileNo + "]";
	}
	
	
	
	
}
