package com.opd_management.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AdminDto {

	@NotBlank(message = "name is required")
	@Size(min = 3,max = 50 ,message = "Name must be between 3–50 characters")
	private String name;
	
	@NotBlank(message = "Email is Required")
	@Email(message = "Enter Valid Email address")
	private String email;
	
	@NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters")
	private String password;
	
	@NotBlank(message = "Mobile number is required")
	@Pattern(regexp="^[0-9]{10}$",message = "Mobile number must be exactly 10 digits")
	private String mobileNo;
	
	private String token;
	
//	@NotNull(message = "Creating date must be past or present")
//	private LocalDateTime created_at;
//	
//	@NotNull
//	(message = "Creating date must be past or present")
//	private LocalDateTime update_at;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

//	public LocalDateTime getCreated_at() {
//		return created_at;
//	}
//
//	public void setCreated_at(LocalDateTime created_at) {
//		this.created_at = created_at;
//	}
//
//	public LocalDateTime getUpdate_at() {
//		return update_at;
//	}
//
//	public void setUpdate_at(LocalDateTime update_at) {
//		this.update_at = update_at;
//	}

	
}
