package com.opd_management.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

//FrontEnd Data Temporary Store   
public class ReferralDto {

	@NotBlank(message = "Note type is required")
	private String note_type;
	
	@NotBlank(message = "Reason is required")
	private String reason;
	
	@NotBlank(message = "Details are required")
    @Size(max = 500, message = "Details cannot exceed 500 characters")
	private String detalis;
	
	@NotBlank(message = "Created date is required")
	private String created_at;
	
	@NotNull(message = "Id must be required")
	@Positive(message = "ID must be positive")
	private int visitid;
	
	@NotNull(message = "Id must be required")
	@Positive(message = "ID must be positive")
	private int patientid;
	
	@NotNull(message = "Id must be required")
	@Positive(message = "ID must be positive")
	private int doctorid;
	
	@NotNull(message = "Id must be required")
	@Positive(message = "ID must be positive")
	private int referralCenterid;

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

	public int getVisitid() {
		return visitid;
	}

	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	public int getReferralCenterid() {
		return referralCenterid;
	}

	public void setReferralCenterid(int referralCenterid) {
		this.referralCenterid = referralCenterid;
	}

	
}
