package com.opd_management.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

//FrontEnd Data Temporary Store   
public class Pathology_TestDto {

	@NotBlank(message = "Result is required")
	private String result;
	
	@NotBlank(message = "Remarks is required")
	@Size(max = 500, message = "Remarks cannot exceed 500 characters")
	private String remarks;
	
	// 
	private String report_file;
	
	@NotBlank(message = "Created date is required")
	private String created_at;
	
	@NotNull(message = "id is required")
	@Positive(message = "ID must be positive")
	private int visitid;
	
	private int testMasterid;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getReport_file() {
		return report_file;
	}

	public void setReport_file(String report_file) {
		this.report_file = report_file;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getVisitid() {
		return visitid;
	}

	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}

	public int getTestMasterid() {
		return testMasterid;
	}

	public void setTestMasterid(int testMasterid) {
		this.testMasterid = testMasterid;
	}
	
	
}
