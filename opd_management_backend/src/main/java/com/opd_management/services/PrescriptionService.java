package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Prescription;

public interface PrescriptionService {

	// to save/ insert data into prescription
	Prescription savePrescription(Prescription prescription);
	
	//  to get all prescription
	List<Prescription> getAllPrescription();
	
	// get specific id 
	Prescription getPrescriptionById(int id);
	
	// delete  specific id
	void deletePrescription(int id);
	
	
}
