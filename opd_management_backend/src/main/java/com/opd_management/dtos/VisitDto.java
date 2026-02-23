package com.opd_management.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

//FrontEnd Data Temporary Store   
public class VisitDto {
	
//	@NotNull(message = "Visit date is required")
	private LocalDate visitDate;
	
	@NotBlank(message = "Complaints field is required")
	private String complaints;
	
	@NotBlank(message = "Diagnosis is required")
	private String diagnosis;
	
	@NotBlank(message = "Advice is required")
	private String advice;
	
	// BP format example: 120/80
    @Pattern(regexp = "^[0-9]{2,3}/[0-9]{2,3}$", message = "BP must be in valid format (e.g., 120/80)")
	private String bp;
    
    @Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String pulse;
    
    @Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String saturation;
    
    @Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String temperature;
    
    @Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String respiration;
    
    @Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String sugar;
    
    @Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String fasting_sugar;
    
    @Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String pp_sugar;
    
    @Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String random_sugar;
    
    @Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String urea_creatinine;
    
    @Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String past_history;
    
    @Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String current_medication;
    
    @Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String additional_notes;
	
	@NotNull(message = "Weight is required")
    @Min(value = 1, message = "Weight must be greater than 0")
	private int weight;
	
	@Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String edema;
	
	@Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String pallor;
	
	@Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String jaundice;
	
	@Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String cvs;
	
	@Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String rs;
	
	@Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String pa;
	
	@Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String cns;
	
	@Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String hb;
	
	@Pattern(regexp = "^(Yes|No)$", message = "Value must be Yes or No")
	private String ecg;
	
	@NotNull(message = "Followup date is required")
	private LocalDateTime followup_date;
	

	private LocalDateTime created_at;
	

	private LocalDateTime updates_at;
	
	
	@NotNull(message = "Id must be required")
	@Positive(message = "ID must be positive")
	private int patientid;  // IMP
	
	@NotNull(message = "Id must be required")
	@Positive(message = "ID must be positive")
	private int doctorid;   // IMP

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public String getComplaints() {
		return complaints;
	}

	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getPulse() {
		return pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	public String getSaturation() {
		return saturation;
	}

	public void setSaturation(String saturation) {
		this.saturation = saturation;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getRespiration() {
		return respiration;
	}

	public void setRespiration(String respiration) {
		this.respiration = respiration;
	}

	public String getSugar() {
		return sugar;
	}

	public void setSugar(String sugar) {
		this.sugar = sugar;
	}

	public String getFasting_sugar() {
		return fasting_sugar;
	}

	public void setFasting_sugar(String fasting_sugar) {
		this.fasting_sugar = fasting_sugar;
	}

	public String getPp_sugar() {
		return pp_sugar;
	}

	public void setPp_sugar(String pp_sugar) {
		this.pp_sugar = pp_sugar;
	}

	public String getRandom_sugar() {
		return random_sugar;
	}

	public void setRandom_sugar(String random_sugar) {
		this.random_sugar = random_sugar;
	}

	public String getUrea_creatinine() {
		return urea_creatinine;
	}

	public void setUrea_creatinine(String urea_creatinine) {
		this.urea_creatinine = urea_creatinine;
	}

	public String getPast_history() {
		return past_history;
	}

	public void setPast_history(String past_history) {
		this.past_history = past_history;
	}

	public String getCurrent_medication() {
		return current_medication;
	}

	public void setCurrent_medication(String current_medication) {
		this.current_medication = current_medication;
	}

	public String getAdditional_notes() {
		return additional_notes;
	}

	public void setAdditional_notes(String additional_notes) {
		this.additional_notes = additional_notes;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getEdema() {
		return edema;
	}

	public void setEdema(String edema) {
		this.edema = edema;
	}

	public String getPallor() {
		return pallor;
	}

	public void setPallor(String pallor) {
		this.pallor = pallor;
	}

	public String getJaundice() {
		return jaundice;
	}

	public void setJaundice(String jaundice) {
		this.jaundice = jaundice;
	}

	public String getCvs() {
		return cvs;
	}

	public void setCvs(String cvs) {
		this.cvs = cvs;
	}

	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	public String getPa() {
		return pa;
	}

	public void setPa(String pa) {
		this.pa = pa;
	}

	public String getCns() {
		return cns;
	}

	public void setCns(String cns) {
		this.cns = cns;
	}

	public String getHb() {
		return hb;
	}

	public void setHb(String hb) {
		this.hb = hb;
	}

	public String getEcg() {
		return ecg;
	}

	public void setEcg(String ecg) {
		this.ecg = ecg;
	}

	public LocalDateTime getFollowup_date() {
		return followup_date;
	}

	public void setFollowup_date(LocalDateTime followup_date) {
		this.followup_date = followup_date;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdates_at() {
		return updates_at;
	}

	public void setUpdates_at(LocalDateTime updates_at) {
		this.updates_at = updates_at;
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

	
}
