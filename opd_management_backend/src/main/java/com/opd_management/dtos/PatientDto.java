package com.opd_management.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

//FrontEnd Data Temporary Store   
public class PatientDto {
	
	@NotBlank(message = " name is required")
	private String patient_name;
	
	@Min(value = 0, message="Age cannot be negative")
	private int age;
	
	@NotBlank(message = "Gender is required")
	private String gender;
	
	@NotNull(message = "Mobile no is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
	private String mobileNo;
	
	@NotBlank(message = "Address is required")
	private String address;
	
	@NotBlank(message = "Blood group is required")
	@Pattern(
			regexp = "^(A|B|AB|O)[+-]$",
			message = "Blood group must be valid like A+, B-, O+, AB-"
			)
	private String blood_group;
	
	@NotBlank(message = "Height is required")
	private String height;
	
	@NotBlank(message = "This smoking field is required y/n")
	@Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String smoking; // optional fields
	
	@NotBlank(message = "This alcohol field is required y/n")
	@Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String alcohol; // optional fields
	
	@NotBlank(message = "This tobacco field is require y/n")
	@Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String tobacco; // optional fields
	
	@PastOrPresent(message = "Date must be past or present")
	private String created_at;
	
	
	// Create Doctor id Separate
	@NotNull(message = "Id must be required")
	@Positive(message = "ID must be positive")
	private int doctorid;


	public String getPatient_name() {
		return patient_name;
	}


	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getBlood_group() {
		return blood_group;
	}


	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public String getSmoking() {
		return smoking;
	}


	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}


	public String getAlcohol() {
		return alcohol;
	}


	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}


	public String getTobacco() {
		return tobacco;
	}


	public void setTobacco(String tobacco) {
		this.tobacco = tobacco;
	}


	public String getCreated_at() {
		return created_at;
	}


	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}


	public int getDoctorid() {
		return doctorid;
	}


	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}


	

}
