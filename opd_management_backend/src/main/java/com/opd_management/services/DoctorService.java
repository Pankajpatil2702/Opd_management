package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Doctor;

public interface DoctorService {
	
	// to save/ insert data into doctor
	Doctor saveDoctor(Doctor doctor);
	
	// get all data from doctor
	List<Doctor> getAllDoctor();
	
	// get specific data using from doctor
	Doctor getDoctorById(int id);
	
	// to delete specific data using id from doctor
	void deleteDoctorId(int id);

}
