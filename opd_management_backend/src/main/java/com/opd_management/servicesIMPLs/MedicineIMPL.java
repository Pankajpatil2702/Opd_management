package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Medicine;
import com.opd_management.repositories.MedicineRepository;
import com.opd_management.services.MedicineService;

@Service
public class MedicineIMPL implements MedicineService {

	@Autowired
	private MedicineRepository medicineRepository;
	
	@Override
	public Medicine saveMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return medicineRepository.save(medicine);
	}

	@Override
	public List<Medicine> getAllMedicine() {
		// TODO Auto-generated method stub
		return medicineRepository.findAll();
	}

	@Override
	public Medicine getMedicineById(int id) {
		// TODO Auto-generated method stub
		return medicineRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteMedicine(int id) {
		// TODO Auto-generated method stub
		medicineRepository.deleteById(id);
	}

}
