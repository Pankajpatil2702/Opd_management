package com.opd_management.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.opd_management.dtos.MedicineDto;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Medicine;
import com.opd_management.services.DoctorService;
import com.opd_management.services.MedicineService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

	
	@Autowired
	private MedicineService medicineService;
	
	@Autowired
	private DoctorService doctorService;
	
	// insert data into medicine table
	@PostMapping("/")
	public ResponseEntity<Medicine> saveMedicineEntity(@Valid @RequestBody MedicineDto medicineDto){
		
		Medicine medicine = new Medicine();
		
		medicine.setMedicine_name(medicineDto.getMedicine_name());
		medicine.setType(medicineDto.getType());
		
		// to get doctor id or show info
		Doctor doctor = doctorService.getDoctorById(medicineDto.getDoctorid());
		
		medicine.setDoctorid(doctor);
		
		Medicine saveMedicine = medicineService.saveMedicine(medicine);
		
		return new ResponseEntity<>(saveMedicine,  HttpStatus.CREATED);
	}
	
	// get all Medicine data
	@GetMapping("/")
	public ResponseEntity<List<Medicine>> getAllMedicineDataFromTable(){
		
		List<Medicine> medicine = medicineService.getAllMedicine();
		
		if(medicine == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(medicine , HttpStatus.FOUND);
				
	}
	
	// get Specific id from medicine table
	@GetMapping("/{id}")
	public ResponseEntity<Medicine> getSpecificIdFromMedicine(@PathVariable("id") int id){
		
		Medicine medicine = medicineService.getMedicineById(id);
		
		if(medicine == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(medicine , HttpStatus.FOUND);
	}
	
	// update specific id from medicine table
	@PutMapping("/{id}")
	public ResponseEntity<Medicine> updateIdFromMedicine(@PathVariable("id") int id,@Valid  @RequestBody MedicineDto medicineDto){
		
		Medicine medicine = medicineService.getMedicineById(id);
		
		if(medicine == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		medicine.setMedicine_name(medicineDto.getMedicine_name());
		medicine.setType(medicineDto.getType());
		
		
		// to get doctor id or show info
		Doctor doctor = doctorService.getDoctorById(medicineDto.getDoctorid());
		
		medicine.setDoctorid(doctor);
		
		Medicine updateMedicine = medicineService.saveMedicine(medicine);
		
		return new ResponseEntity<>(updateMedicine, HttpStatus.OK);
	}
	
	
	// delete specific id from medicine 
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>  deleteIdFromMedicine(@PathVariable("id") int id){
		
		Medicine medicine = medicineService.getMedicineById(id);
		
		if(medicine == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		medicineService.deleteMedicine(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}

