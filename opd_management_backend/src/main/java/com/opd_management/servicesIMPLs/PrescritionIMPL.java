package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Prescription;
import com.opd_management.exception.DataBaseException;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.PrescriptionRepository;
import com.opd_management.services.PrescriptionService;

@Service
public class PrescritionIMPL implements PrescriptionService {

	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	
	@Override
	public Prescription savePrescription(Prescription prescription) {


		try {
			
			return prescriptionRepository.save(prescription);
			
		} catch (Exception e) {
				
			throw new DataBaseException("Failed to save prescription due to database error");
		}
	}

	@Override
	public List<Prescription> getAllPrescription() {
		
		try {
			
			return prescriptionRepository.findAll();
			
		} catch (Exception e) {

			throw new DataBaseException("Failed to find prescription due to database error");
		}
	}

	@Override
	public Prescription getPrescriptionById(int id) {
		// TODO Auto-generated method stub
		return prescriptionRepository.findById(id).orElseThrow(() -> new
				ResourseNotFoundException("bill not found with id: " + id));
	}

	@Override
	public void deletePrescription(int id) {
		
		try {
			
			prescriptionRepository.deleteById(id);
			
		} catch (Exception e) {
			
			throw new DataBaseException("Failed to delete prescription due to database error");
		}
		
	}

}
