package com.opd_management.dtos;

//FrontEnd Data Temporary Store   
public class VisitDto {
	
	private String visit_date;
	private String complaints;
	private String diagnosis;
	private String advice;
	private String bp;
	private String pulse;
	private String saturation;
	private String temperature;
	private String respiration;
	private String sugar;
	private String fasting_sugar;
	private String pp_sugar;
	private String random_sugar;
	private String urea_creatinine;
	private String past_history;
	private String current_medication;
	private String additional_notes;
	private int weight;
	private String edema;
	private String pallor;
	private String jaundice;
	private String cvs;
	private String rs;
	private String pa;
	private String  cns;
	private String hb;
	private String ecg;
	private String followup_date;
	private String created_at;
	private String updates_at;
	
	private int patientid;  // IMP
	
	private int doctorid;   // IMP

	public String getVisit_date() {
		return visit_date;
	}

	public void setVisit_date(String visit_date) {
		this.visit_date = visit_date;
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

	public String getFollowup_date() {
		return followup_date;
	}

	public void setFollowup_date(String followup_date) {
		this.followup_date = followup_date;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdates_at() {
		return updates_at;
	}

	public void setUpdates_at(String updates_at) {
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
