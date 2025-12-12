package com.opd_management.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

//FrontEnd Data Temporary Store   
public class MedicineDto {

	@NotBlank(message = "Medicine name is required")
	@Pattern(
	    regexp = "^[A-Za-z0-9 .,-]+$",
	    message = "Medicine name contains invalid characters"
	)
	private String medicine_name;
	
	@NotBlank(message = "Type is required")
	@Pattern(
	    regexp = "^[A-Za-z]+$",
	    message = "Type must contain only letters"
	)
	private String type;
	
	
	private int doctorid;

	public String getMedicine_name() {
		return medicine_name;
	}

	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
}
