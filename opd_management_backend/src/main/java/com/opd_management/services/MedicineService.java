package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Medicine;

public interface MedicineService {

	// insert Data into medicine
	Medicine saveMedicine(Medicine medicine);
	
	// get all medicine records
	List<Medicine> getAllMedicine();
	
	// get specific id from medicine
	Medicine getMedicineById(int id);
	
	// delete specific id from medicine
	void deleteMedicine(int id);
}
