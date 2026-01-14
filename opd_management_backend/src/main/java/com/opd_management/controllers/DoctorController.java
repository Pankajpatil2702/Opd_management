package com.opd_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.opd_management.dtos.DoctorDto;
import com.opd_management.entities.Doctor;
import com.opd_management.services.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PasswordEncoder encoder;

	
	@PostMapping("/regsiter")
	public ResponseEntity<Doctor> saveDoctorEntity(@Valid @RequestBody DoctorDto doctorDto){
		
			
			Doctor doctor= new Doctor();
			
			doctor.setName(doctorDto.getName());
			doctor.setEmail(doctorDto.getEmail());
			
			doctor.setPassword(encoder.encode(doctorDto.getPassword()));       // new line added for encode
			doctor.setSpecialization(doctorDto.getSpecialization());
			doctor.setClinic_name(doctorDto.getClinic_name());
			doctor.setAddress(doctorDto.getAddress());
			doctor.setMobileNo(doctorDto.getMobileNo());
			
			doctor.setToken(doctorDto.getToken());
			doctor.setStatus(doctorDto.getStatus());
			doctor.setCreated_at(doctorDto.getCreated_at());
			doctor.setUpdated_at(doctorDto.getUpdated_at());
			
			Doctor saveDoctor = doctorService.saveDoctor(doctor);
			
			return new ResponseEntity<>(saveDoctor , HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
		public ResponseEntity<List<Doctor>> getAllListDoctor(){
		
		try {														// add try catch block
			List<Doctor> doctors = doctorService.getAllDoctor();
			
			if(doctors == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(doctors, HttpStatus.FOUND);
		}
		catch(Exception e) {
		
			
			return new ResponseEntity<>(  HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctorId(@PathVariable("id") int id){
		
		
		Doctor doctor = doctorService.getDoctorById(id);
		if(doctor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<>(doctor , HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") int id,@Valid  @RequestBody DoctorDto doctorDto){
		
		Doctor doctor = doctorService.getDoctorById(id);
		
		doctor.setName(doctorDto.getName());
		doctor.setEmail(doctorDto.getEmail());
		doctor.setPassword(doctorDto.getPassword());
		doctor.setSpecialization(doctorDto.getSpecialization());
		doctor.setClinic_name(doctorDto.getClinic_name());
		doctor.setAddress(doctorDto.getAddress());
		doctor.setMobileNo(doctorDto.getMobileNo());
		doctor.setToken(doctorDto.getToken());
		doctor.setStatus(doctorDto.getStatus());
		doctor.setCreated_at(doctorDto.getCreated_at());
		doctor.setUpdated_at(doctorDto.getUpdated_at());
		
		Doctor updateDoctor = doctorService.saveDoctor(doctor);
		
		return new ResponseEntity<>(updateDoctor, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDoctorId(@PathVariable("id") int id){
		
		Doctor doctor= doctorService.getDoctorById(id);
		if(doctor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		doctorService.deleteDoctorId(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
}
