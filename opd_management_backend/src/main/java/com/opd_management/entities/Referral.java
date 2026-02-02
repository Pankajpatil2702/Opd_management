package com.opd_management.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "referrals")
public class Referral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String note_type;
	private String reason;
	private String detalis;
	private String created_at;
	
	@ManyToOne
	@JoinColumn(name = "visitId")
	@JsonIgnoreProperties(value = {"visitid"} , allowSetters = true)
	private Visit visitid;
	
	@ManyToOne
	@JoinColumn(name = "patientId")
	@JsonIgnoreProperties(value = {"patientid"} , allowSetters = true)
	private Patient patientid;
	
	@ManyToOne
	@JoinColumn(name = "doctorId")
	@JsonIgnoreProperties(value = {"doctorid"} , allowSetters = true)
	private Doctor doctorid;
	
	@ManyToOne
	@JoinColumn(name = "referralCenterId")
	@JsonIgnoreProperties(value = {"referralCenterid"} , allowSetters = true)
	private Referral_Center referralCenterid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNote_type() {
		return note_type;
	}

	public void setNote_type(String note_type) {
		this.note_type = note_type;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDetalis() {
		return detalis;
	}

	public void setDetalis(String detalis) {
		this.detalis = detalis;
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

	public Patient getPatientid() {
		return patientid;
	}

	public void setPatientid(Patient patientid) {
		this.patientid = patientid;
	}

	public Doctor getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(Doctor doctorid) {
		this.doctorid = doctorid;
	}

	public Referral_Center getReferralCenterid() {
		return referralCenterid;
	}

	public void setReferralCenterid(Referral_Center referralCenterid) {
		this.referralCenterid = referralCenterid;
	}

	public Referral(int id, String note_type, String reason, String detalis, String created_at, Visit visitid,
			Patient patientid, Doctor doctorid, Referral_Center referralCenterid) {
		super();
		this.id = id;
		this.note_type = note_type;
		this.reason = reason;
		this.detalis = detalis;
		this.created_at = created_at;
		this.visitid = visitid;
		this.patientid = patientid;
		this.doctorid = doctorid;
		this.referralCenterid = referralCenterid;
	}

	public Referral() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Referral [id=" + id + ", note_type=" + note_type + ", reason=" + reason + ", detalis=" + detalis
				+ ", created_at=" + created_at + ", visitid=" + visitid + ", patientid=" + patientid + ", doctorid="
				+ doctorid + ", referralCenterid=" + referralCenterid + "]";
	}

	
}
