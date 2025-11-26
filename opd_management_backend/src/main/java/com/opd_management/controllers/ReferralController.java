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

import com.opd_management.dtos.ReferralDto;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Patient;
import com.opd_management.entities.Referral;
import com.opd_management.entities.Referral_Center;
import com.opd_management.entities.Visit;
import com.opd_management.services.DoctorService;
import com.opd_management.services.PatientService;
import com.opd_management.services.ReferralService;
import com.opd_management.services.Referral_CenterService;
import com.opd_management.services.VisitService;

@RestController
@RequestMapping("/referral")
public class ReferralController {
	
	@Autowired
	private ReferralService referralService;
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private Referral_CenterService referral_CenterService;
	
	
	// insert data into referral table
	@PostMapping("/")
	public ResponseEntity<Referral> saveReferralEntity(@RequestBody ReferralDto referralDto){
		
		 Referral referral = new Referral();
		 
		 referral.setNote_type(referralDto.getNote_type());
		 referral.setReason(referralDto.getReason());
		 referral.setDetalis(referralDto.getDetalis());
		 referral.setCreated_at(referralDto.getCreated_at());
		 
		 Visit visit = visitService.getVisitByID(referralDto.getVisitid());  // get visit data/id for details
		 referral.setVisitid(visit);
		 
		 Patient patient = patientService.getPatientById(referralDto.getPatientid());  // get patient data/id for details
		 referral.setPatientid(patient);
		 
		 Doctor doctor = doctorService.getDoctorById(referralDto.getDoctorid());  // get doctor data/id for details
		 referral.setDoctorid(doctor);
		 
		 Referral_Center referral_Center = referral_CenterService.getReferral_CenterById(referralDto.getReferralCenterid());  // get referral_center data/id for details
		 referral.setReferralCenterid(referral_Center);
		 
		 Referral saveReferral = referralService.saveReferral(referral);
		 
		 return new ResponseEntity<>(saveReferral, HttpStatus.CREATED);
	}
	
	// get all data from referral 
	@GetMapping("/")
	public ResponseEntity<List<Referral>> getAllDataFromReferral(){
		
		List<Referral> referral = referralService.getAllReferral();
		
		if(referral == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(referral , HttpStatus.FOUND);
				
		
	}
	
	
	// get data using id from referral table
	@GetMapping("/{id}")
	public ResponseEntity<Referral> getReferralDataById(@PathVariable("id") int id, @RequestBody ReferralDto referralDto){
		
		Referral referral = referralService.getReferralById(id);
		
		if(referral == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(referral , HttpStatus.FOUND);
	}
	
	// update specific data using data from referral table
	@PutMapping("/{id}")
	public ResponseEntity<Referral> updateDataFromReferralById(@PathVariable("id") int id, @RequestBody ReferralDto referralDto){
		
		Referral referral = referralService.getReferralById(id);
		if(referral == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		referral.setNote_type(referralDto.getNote_type());
		 referral.setReason(referralDto.getReason());
		 referral.setDetalis(referralDto.getDetalis());
		 referral.setCreated_at(referralDto.getCreated_at());
		 
		 Visit visit = visitService.getVisitByID(referralDto.getVisitid());  // get visit data/id for details
		 referral.setVisitid(visit);
		 
		 Patient patient = patientService.getPatientById(referralDto.getPatientid());  // get patient data/id for details
		 referral.setPatientid(patient);
		 
		 Doctor doctor = doctorService.getDoctorById(referralDto.getDoctorid());  // get doctor data/id for details
		 referral.setDoctorid(doctor);
		 
		 Referral_Center referral_Center = referral_CenterService.getReferral_CenterById(referralDto.getReferralCenterid());  // get referral_center data/id for details
		 referral.setReferralCenterid(referral_Center);
		 
		 Referral updateReferral = referralService.saveReferral(referral);
		 
		 return new ResponseEntity<>(updateReferral, HttpStatus.OK);
		
	}
	
	
	// delete specific id from referral table
	@DeleteMapping("/{id}")
	public ResponseEntity<Referral> deleteReferralIdFromTable(@PathVariable("id") int id){
		
		Referral referral = referralService.getReferralById(id);
		
		if(referral == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		referralService.deleteReferralById(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		
	}

}
