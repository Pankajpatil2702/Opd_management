package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Medicine;
import com.opd_management.exception.DataBaseException;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.MedicineRepository;
import com.opd_management.services.MedicineService;

@Service
public class MedicineIMPL implements MedicineService {

	@Autowired
	private MedicineRepository medicineRepository;
	
	@Override
	public Medicine saveMedicine(Medicine medicine) {
		try {
			return medicineRepository.save(medicine);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to save medicine due to database error");
		}
	}

	@Override
	public List<Medicine> getAllMedicine() {
		try {
			return medicineRepository.findAll();
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to find medicine data due to database error");
		}
	}

	@Override
	public Medicine getMedicineById(int id) {
		// TODO Auto-generated method stub
		return medicineRepository.findById(id).orElseThrow(() -> new
				ResourseNotFoundException("medicine not found with id: " + id));
	}

	@Override
	public void deleteMedicine(int id) {
		try {
			
			medicineRepository.deleteById(id);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to delete medicine data due to database error");
		}
		
	}

}
