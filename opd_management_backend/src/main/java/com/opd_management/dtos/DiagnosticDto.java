package com.opd_management.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

//FrontEnd Data Temporary Store   
public class DiagnosticDto {
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Date is required")
	private String created_at;
	
	
	@NotNull(message = "Id must be required")
	@Positive(message = "ID must be positive")
	private int doctorid;
	
	
	@NotNull(message = "Id must be required")
	@Positive(message = "ID must be positive")
	private int visitid;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getVisitid() {
		return visitid;
	}

	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}

	
	

}
