package com.opd_management.dtos;

public class Pathology_TestDto {

	private String result;
	private String remarks;
	private String report_file;
	private String created_at;
	
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
