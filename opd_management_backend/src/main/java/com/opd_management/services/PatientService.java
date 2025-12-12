package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Patient;

public interface PatientService {
	
	// to save/insert data into patient
	Patient savePatient(Patient patient);
	
	//  get all data from patient
	List<Patient> getAllPatient();
	
	// get specific data using id from patient
	Patient getPatientById(int id);
	
	// delete specific data using id from patient
	void deletePatient(int id);
	
	// get patient list accroding to doctor id
	List<Patient> getPatientByDoctorid(int doctorid);

}
