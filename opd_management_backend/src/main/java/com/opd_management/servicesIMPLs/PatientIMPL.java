package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.opd_management.entities.Patient;
import com.opd_management.exception.DataBaseException;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.PatientRepository;
import com.opd_management.services.PatientService;

@Service
public class PatientIMPL implements PatientService {

	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public Patient savePatient(Patient patient) {
		try {
			return patientRepository.save(patient);
		}
		catch(Exception e){
			throw new DataBaseException("Falied to save patient due to database error");
		}
	}

	@Override
	public List<Patient> getAllPatient() {
		try {
			
			return patientRepository.findAll();
		}
		catch(Exception e) {
			throw new DataBaseException("Failed to find patients due to database error");
		}
	}

	@Override
	public Patient getPatientById(int id) {   // add exception 
		// TODO Auto-generated method stub
		return patientRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("patient not found with id:" + id)); 
	}

	@Override
	public void deletePatient(int id) {
		try {
			patientRepository.deleteById(id);
		}
		catch(Exception e) {
			throw new DataBaseException("Failed to delete patient due to database error");
		}
	}

	// new line added
	@Override
	public List<Patient> getPatientByDoctorid(int doctorid) {
		
		return patientRepository.findByDoctorid_Id(doctorid);
	}

}
