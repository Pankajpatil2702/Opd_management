package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Doctor;

public interface DoctorService {
	
	Doctor saveDoctor(Doctor doctor);
	
	List<Doctor> getAllDoctor();
	
	Doctor getDoctorById(int id);
	
	void deleteDoctorId(int id);

}
