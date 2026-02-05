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

import com.opd_management.dtos.PatientDto;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Patient;
import com.opd_management.services.DoctorService;
import com.opd_management.services.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;  // to get id
	
	
	// Get All Data From Patient Table
	@GetMapping("/")
	public ResponseEntity<List<Patient>> getPatientData(){
		
		List<Patient> patient = patientService.getAllPatient();
		
		if(patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}
	
	
	// Insert Data Into Patient Table
	@PostMapping("/")
	public ResponseEntity<Patient> savePatient(@Valid @RequestBody PatientDto patientDto){
		
		Patient patient =  new Patient();
		
		patient.setPatient_name(patientDto.getPatient_name());
		patient.setAge(patientDto.getAge());
		patient.setGender(patientDto.getGender());
		patient.setMobileNo(patientDto.getMobileNo());
		patient.setAddress(patientDto.getAddress());
		patient.setBlood_group(patientDto.getBlood_group());
		patient.setHeight(patientDto.getHeight());
		patient.setSmoking(patientDto.getSmoking());
		patient.setAlcohol(patientDto.getAlcohol());
		patient.setTobacco(patientDto.getTobacco());
		patient.setCreated_at(patientDto.getCreated_at());
		
		
		// to get doctor id
		Doctor doctor= doctorService.getDoctorById(patientDto.getDoctorid());  // This is Used For Get All Data/id From Doctor Table
		
		patient.setDoctorid(doctor);
		
		Patient savePatient= patientService.savePatient(patient);
		
		return new ResponseEntity<>(savePatient, HttpStatus.CREATED);
	}
	
	
	// Get Specific Data From Patient Table Using "id"
	
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientDataByid(@PathVariable("id") int id){
		
		Patient patient= patientService.getPatientById(id);
		
		if(patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}
	
	// Update Specific Data From Patient Table Using "id"
	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatientData(@PathVariable("id") int id,@Valid  @RequestBody PatientDto patientDto){
		
		Patient patient = patientService.getPatientById(id);
		
		patient.setPatient_name(patientDto.getPatient_name());
		patient.setAge(patientDto.getAge());
		patient.setGender(patientDto.getGender());
		patient.setMobileNo(patientDto.getMobileNo());
		patient.setAddress(patientDto.getAddress());
		patient.setBlood_group(patientDto.getBlood_group());
		patient.setHeight(patientDto.getHeight());
		patient.setSmoking(patientDto.getSmoking());
		patient.setAlcohol(patientDto.getAlcohol());
		patient.setTobacco(patientDto.getTobacco());
		patient.setCreated_at(patientDto.getCreated_at());
		
		
		// to get doctor id
		Doctor doctor = doctorService.getDoctorById(patientDto.getDoctorid()); 
		
		patient.setDoctorid(doctor);
		
		Patient updatePatient = patientService.savePatient(patient);
		
		return new ResponseEntity<>(updatePatient, HttpStatus.OK); 
	}
	
	// new line added
	@GetMapping("/bydoctorid/{doctorid}")
	public ResponseEntity<List<Patient>> listBydoctorid(@PathVariable int doctorid){
		List<Patient> patients =patientService.getPatientByDoctorid(doctorid);
		if(patients == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(patients, HttpStatus.OK);
	}
	
	
	
	// Delete Specific Id From Patient Table
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePatientDataUsingId(@PathVariable("id") int id){
		
		Patient patient = patientService.getPatientById(id);
		if(patient == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		patientService.deletePatient(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
