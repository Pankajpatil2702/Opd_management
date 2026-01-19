package com.opd_management.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PrescriptionDto {
	
	@NotBlank(message = "Dosage is required")
	private String dosage;
	
	@NotBlank(message = "Duration is required")
	private String durtion;
	
	@NotBlank(message = "Instructions are required")
    @Size(max = 255, message = "Instructions must be less than 255 characters")
	private String instrucations;
	
	@Min(value = 1, message = "Quantity must be at least 1")
	private int quality;
	
	@NotBlank(message = "Created date is required")
	private String created_at;
	
	@Min(value = 0, message = "Morning dose cannot be negative")
	private int morning_dose;
	
	@Min(value = 0, message = "Afternoon dose cannot be negative")
	private int afternoon_dose;
	
	@Min(value = 1, message = "Duration days must be at least 1")
	private int duration_days;
	
	@Min(value = 1, message = "Total quantity must be at least 1")
	private int total_quantity;
	
	@Size(max = 100, message = "Quantity note must be less than 100 characters")
	private String quantity_note;
	
	@NotBlank(message = "Dose quantity is required")
	private String dose_qty;
	
	@NotBlank(message = "Unit is required")
	private String unit;
	
	@NotNull(message = "Visit ID is required")
    @Min(value = 1, message = "Visit ID must be valid")
	private int visitid;
	
	@NotNull(message = "Medicine ID is required")
    @Min(value = 1, message = "Medicine ID must be valid")
	private int medicineid;

	
	
	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getDurtion() {
		return durtion;
	}

	public void setDurtion(String durtion) {
		this.durtion = durtion;
	}

	public String getInstrucations() {
		return instrucations;
	}

	public void setInstrucations(String instrucations) {
		this.instrucations = instrucations;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getMorning_dose() {
		return morning_dose;
	}

	public void setMorning_dose(int morning_dose) {
		this.morning_dose = morning_dose;
	}

	public int getAfternoon_dose() {
		return afternoon_dose;
	}

	public void setAfternoon_dose(int afternoon_dose) {
		this.afternoon_dose = afternoon_dose;
	}

	public int getDuration_days() {
		return duration_days;
	}

	public void setDuration_days(int duration_days) {
		this.duration_days = duration_days;
	}

	public int getTotal_quantity() {
		return total_quantity;
	}

	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
	}

	public String getQuantity_note() {
		return quantity_note;
	}

	public void setQuantity_note(String quantity_note) {
		this.quantity_note = quantity_note;
	}

	public String getDose_qty() {
		return dose_qty;
	}

	public void setDose_qty(String dose_qty) {
		this.dose_qty = dose_qty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getVisitid() {
		return visitid;
	}

	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}

	public int getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
	}
	
	
}
