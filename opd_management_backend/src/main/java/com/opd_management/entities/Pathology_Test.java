package com.opd_management.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pathology_tests")
public class Pathology_Test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String result;
	private String remarks;
	private String report_file;
	private String created_at;
	
	@ManyToOne
	@JoinColumn(name = "visitId")
	@JsonIgnoreProperties(value = {"visitid"}, allowSetters = true)
	private Visit visitid;
	
	
	@ManyToOne
	@JoinColumn(name = "test_master")
	@JsonIgnoreProperties(value = {"testmaster"} , allowSetters = true)
	private Tests_Master testMasterid;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


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


	public Visit getVisitid() {
		return visitid;
	}


	public void setVisitid(Visit visitid) {
		this.visitid = visitid;
	}


	public Tests_Master getTestMasterid() {
		return testMasterid;
	}


	public void setTestMasterid(Tests_Master testMasterid) {
		this.testMasterid = testMasterid;
	}


	public Pathology_Test(int id, String result, String remarks, String report_file, String created_at, Visit visitid,
			Tests_Master testMasterid) {
		super();
		this.id = id;
		this.result = result;
		this.remarks = remarks;
		this.report_file = report_file;
		this.created_at = created_at;
		this.visitid = visitid;
		this.testMasterid = testMasterid;
	}


	public Pathology_Test() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Pathology_Test [id=" + id + ", result=" + result + ", remarks=" + remarks + ", report_file="
				+ report_file + ", created_at=" + created_at + ", visitid=" + visitid + ", testMasterid=" + testMasterid
				+ "]";
	}


	
	
}
