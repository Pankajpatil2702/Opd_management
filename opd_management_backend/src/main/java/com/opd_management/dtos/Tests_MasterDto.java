package com.opd_management.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

//FrontEnd Data Temporary Store   
public class Tests_MasterDto {
	
	@NotBlank(message = "Test name is required")
	@Pattern(
	    regexp = "^[A-Za-z0-9 .,-]+$",
	    message = "Test name contains invalid characters"
	)
	private String test_name;
	
	@NotBlank(message = "Normal range is required")
	@Size(max = 50, message = "Normal range cannot exceed 50 characters")
	private String normal_range;
	
	@Pattern(
		    regexp = "^(mg/dL|g/dL|mmol/L|%|IU/L)$",
		    message = "Unit must be one of the allowed units"
		)
	private String unit;
	
	
	
	private int doctorid;

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	public String getNormal_range() {
		return normal_range;
	}

	public void setNormal_range(String normal_range) {
		this.normal_range = normal_range;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

}
