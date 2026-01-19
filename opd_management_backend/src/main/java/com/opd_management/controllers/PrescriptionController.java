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

import com.opd_management.dtos.PrescriptionDto;
import com.opd_management.entities.Medicine;
import com.opd_management.entities.Prescription;
import com.opd_management.entities.Visit;
import com.opd_management.services.MedicineService;
import com.opd_management.services.PrescriptionService;
import com.opd_management.services.VisitService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
	
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private MedicineService medicineService;
	
	
	@PostMapping("/")
	public ResponseEntity<Prescription> savePrescriptionEntity(@Valid @RequestBody PrescriptionDto prescriptionDto){
		
		
		Prescription prescription = new Prescription();
		
		prescription.setDosage(prescriptionDto.getDosage());
		prescription.setDurtion(prescriptionDto.getDurtion());
		prescription.setInstrucations(prescriptionDto.getInstrucations());
		prescription.setQuality(prescriptionDto.getQuality());
		prescription.setCreated_at(prescriptionDto.getCreated_at());
		prescription.setMorning_dose(prescriptionDto.getMorning_dose());
		prescription.setAfternoon_dose(prescriptionDto.getAfternoon_dose());
		prescription.setEvening_dose(prescriptionDto.getAfternoon_dose());
		prescription.setDuration_days(prescriptionDto.getDuration_days());
		prescription.setTotal_quantity(prescriptionDto.getTotal_quantity());
		prescription.setQuantity_note(prescriptionDto.getQuantity_note());
		prescription.setDose_qty(prescriptionDto.getDose_qty());
		prescription.setDose_unit(prescriptionDto.getCreated_at());
		
		Visit visit = visitService.getVisitByID(prescriptionDto.getVisitid());
		
		Medicine medicine = medicineService.getMedicineById(prescriptionDto.getMedicineid());
		
		prescription.setVisitid(visit);
		prescription.setMedicineid(medicine);
		
		Prescription savePrescription = prescriptionService.savePrescription(prescription);
		
		return new ResponseEntity<>(savePrescription, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Prescription>>  getAllPrescriptionFromTable(){
		
		List<Prescription> prescription = prescriptionService.getAllPrescription();
		
		if(prescription == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(prescription, HttpStatus.FOUND);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Prescription> getPrescriptionByIdFromTable(@PathVariable("id") int id){
		
		Prescription prescription = prescriptionService.getPrescriptionById(id);
		if(prescription == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(prescription, HttpStatus.FOUND);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Prescription> updatePrescriptionUsingId(@PathVariable("id") int id, @Valid @RequestBody PrescriptionDto  prescriptionDto){
		
		
		Prescription prescription = prescriptionService.getPrescriptionById(id);
		
		if(prescription == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		prescription.setDosage(prescriptionDto.getDosage());
		prescription.setDurtion(prescriptionDto.getDurtion());
		prescription.setInstrucations(prescriptionDto.getInstrucations());
		prescription.setQuality(prescriptionDto.getQuality());
		prescription.setCreated_at(prescriptionDto.getCreated_at());
		prescription.setMorning_dose(prescriptionDto.getMorning_dose());
		prescription.setAfternoon_dose(prescriptionDto.getAfternoon_dose());
		prescription.setEvening_dose(prescriptionDto.getAfternoon_dose());
		prescription.setDuration_days(prescriptionDto.getDuration_days());
		prescription.setTotal_quantity(prescriptionDto.getTotal_quantity());
		prescription.setQuantity_note(prescriptionDto.getQuantity_note());
		prescription.setDose_qty(prescriptionDto.getDose_qty());
		prescription.setDose_unit(prescriptionDto.getCreated_at());
		
		Visit visit = visitService.getVisitByID(prescriptionDto.getVisitid());
		
		Medicine medicine = medicineService.getMedicineById(prescriptionDto.getMedicineid());
		
		prescription.setVisitid(visit);
		prescription.setMedicineid(medicine);
		
		Prescription updatePrescription = prescriptionService.savePrescription(prescription);
		return new ResponseEntity<>(updatePrescription, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePrescriptionUsingId(@PathVariable("id") int id){
		
		Prescription prescription = prescriptionService.getPrescriptionById(id);
		
		if(prescription == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		prescriptionService.deletePrescription(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	
	

}
