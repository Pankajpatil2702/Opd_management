package com.opd_management.controllers;

import java.time.LocalDateTime;
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

import com.opd_management.dtos.Referral_CenterDto;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Referral_Center;
import com.opd_management.services.DoctorService;
import com.opd_management.services.Referral_CenterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/referral_center")
public class Referral_CenterController {
	
	@Autowired
	private Referral_CenterService referral_CenterService;
	
	@Autowired
	private DoctorService doctorService;  // to get id
	
	// insert data from referral_center 
	@PostMapping("/")
	public ResponseEntity<Referral_Center> saveReferral_CenterEntity(@Valid @RequestBody Referral_CenterDto referral_CenterDto){
		
		Referral_Center referral_Center = new Referral_Center();
		
		referral_Center.setName(referral_CenterDto.getName());
		referral_Center.setType(referral_CenterDto.getType());
		referral_Center.setContact_info(referral_CenterDto.getContact_info());
		referral_Center.setAddress(referral_CenterDto.getAddress());
		referral_Center.setCreated_at(LocalDateTime.now());
		
		// to get doctor id show data from id
		Doctor doctor = doctorService.getDoctorById(referral_CenterDto.getDoctorid());
		
		referral_Center.setDoctorid(doctor);
		
		Referral_Center saveReferral_Center = referral_CenterService.saveReferral_Center(referral_Center);
		
		return new ResponseEntity<>(saveReferral_Center, HttpStatus.CREATED);
	}

	// get all data from referral_center
	@GetMapping("/")
	public ResponseEntity<List<Referral_Center>> getAllDataFromReferral_Center(){
		
		List<Referral_Center> referral_Center = referral_CenterService.getAllReferral_Center();
		
		if(referral_Center == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(referral_Center, HttpStatus.OK);
	}
	
	// get specific id from referral_center
	@GetMapping("/{id}")
	public ResponseEntity<Referral_Center> getSpecificReferral_CenterById(@PathVariable("id") int id){
		
		Referral_Center referral_Center = referral_CenterService.getReferral_CenterById(id);
		if(referral_Center == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(referral_Center , HttpStatus.OK);
	}
	
	// update specific id from referral_center
	@PutMapping("/{id}")
	public ResponseEntity<Referral_Center> updateReferral_CenterId(@PathVariable("id") int id,@Valid  @RequestBody Referral_CenterDto referral_CenterDto){
		
		Referral_Center referral_Center= referral_CenterService.getReferral_CenterById(id);
		if(referral_Center == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		referral_Center.setName(referral_CenterDto.getName());
		referral_Center.setType(referral_CenterDto.getType());
		referral_Center.setContact_info(referral_CenterDto.getContact_info());
		referral_Center.setAddress(referral_CenterDto.getAddress());
		referral_Center.setCreated_at(LocalDateTime.now());
		
		// to get doctor id show data from id
		Doctor doctor = doctorService.getDoctorById(referral_CenterDto.getDoctorid());
		
		referral_Center.setDoctorid(doctor);
		
		Referral_Center updateReferral_Center = referral_CenterService.saveReferral_Center(referral_Center);
		
		return new ResponseEntity<>(updateReferral_Center, HttpStatus.OK);
	}
	
	// delete specific id from referral_Center
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSpecificIdFromReferral_Center(@PathVariable("id") int id){
		
		Referral_Center referral_Center= referral_CenterService.getReferral_CenterById(id);
		if(referral_Center == null) {
			 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		referral_CenterService.deleteReferral_CenterById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
}
