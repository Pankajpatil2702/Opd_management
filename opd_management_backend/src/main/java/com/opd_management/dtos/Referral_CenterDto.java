package com.opd_management.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

//FrontEnd Data Temporary Store   
public class Referral_CenterDto {
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Type is required")
	@Pattern(
	    regexp = "^[A-Za-z ]+$",
	    message = "Type must contain only letters"
	)
	private String type;
	
	@NotBlank(message = "Contact info is required")
	private String contact_info;
	
	@NotBlank(message = "Address is required")
	private String address;
	
//	@NotBlank(message = "Created date is required")
//	private LocalDateTime created_at;
	
	
	@NotNull(message = "Id must be required")
	@Positive(message = "ID must be positive")
	private int doctorid;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getContact_info() {
		return contact_info;
	}


	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


//	public LocalDateTime getCreated_at() {
//		return created_at;
//	}
//
//
//	public void setCreated_at(LocalDateTime created_at) {
//		this.created_at = created_at;
//	}


	public int getDoctorid() {
		return doctorid;
	}


	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}


	
}
