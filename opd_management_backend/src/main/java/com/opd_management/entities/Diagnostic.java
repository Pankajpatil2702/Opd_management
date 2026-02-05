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
@Table(name = "diagnositcs")
public class Diagnostic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String created_at;
	
	@ManyToOne
	@JoinColumn(name = ("visitId"))
	@JsonIgnoreProperties(value = {"visitid"} , allowSetters = true)
	private Visit visitid;
	
	
	@ManyToOne
	@JoinColumn(name = ("doctorId"))
	@JsonIgnoreProperties(value = {"doctorid"}, allowSetters = true)
	private Doctor doctorid;


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


	public Doctor getDoctorid() {
		return doctorid;
	}


	public void setDoctorid(Doctor doctorid) {
		this.doctorid = doctorid;
	}


	public Diagnostic(int id, String name, String created_at, Visit visitid, Doctor doctorid) {
		super();
		this.id = id;
		this.name = name;
		this.created_at = created_at;
		this.visitid = visitid;
		this.doctorid = doctorid;
	}


	public Diagnostic() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Diagnostic [id=" + id + ", name=" + name + ", created_at=" + created_at + ", visitid=" + visitid
				+ ", doctorid=" + doctorid + "]";
	}


	
}
