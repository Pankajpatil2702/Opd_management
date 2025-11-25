package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Patient;
import com.opd_management.repositories.PatientRepository;
import com.opd_management.services.PatientService;

@Service
public class PatientIMPL implements PatientService {

	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(int id) {
		// TODO Auto-generated method stub
		return patientRepository.findById(id).orElse(null);
	}

	@Override
	public void deletePatient(int id) {
		// TODO Auto-generated method stub
		patientRepository.deleteById(id);
	}

}
