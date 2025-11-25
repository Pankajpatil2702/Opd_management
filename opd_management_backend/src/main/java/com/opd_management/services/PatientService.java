package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Patient;

public interface PatientService {
	
	Patient savePatient(Patient patient);
	
	List<Patient> getAllPatient();
	
	Patient getPatientById(int id);
	
	void deletePatient(int id);

}
