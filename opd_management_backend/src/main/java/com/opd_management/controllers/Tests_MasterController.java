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

import com.opd_management.dtos.Tests_MasterDto;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Tests_Master;
import com.opd_management.services.DoctorService;
import com.opd_management.services.Tests_MasterService;

@RestController
@RequestMapping("/tests_master")
public class Tests_MasterController {

	@Autowired
	private Tests_MasterService tests_MasterService;
	
	@Autowired
	private DoctorService doctorService;
	
	
	// insert data into tests_master entity
	@PostMapping("/")
	public ResponseEntity<Tests_Master> saveTests_MasterEntity(@RequestBody Tests_MasterDto tests_MasterDto){
		
		Tests_Master tests_Master = new Tests_Master();
		
		tests_Master.setTest_name(tests_MasterDto.getTest_name());
		tests_Master.setNormal_range(tests_MasterDto.getNormal_range());
		tests_Master.setUnit(tests_MasterDto.getUnit());
		
		
		// to get doctor id for show data
		Doctor doctor = doctorService.getDoctorById(tests_MasterDto.getDoctorid());
		
		tests_Master.setDoctorid(doctor);
		
		Tests_Master saveTests_Master = tests_MasterService.saveTests_Master(tests_Master);
		
		return new ResponseEntity<>(saveTests_Master, HttpStatus.CREATED);
				
	}
	
	// get all data from tests_master
	@GetMapping("/")
	public ResponseEntity<List<Tests_Master>>  getAllTests_MasterData(){
		
		List<Tests_Master> tests_Master = tests_MasterService.getAllTests_Master();
		if(tests_Master == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(tests_Master, HttpStatus.FOUND);
	}
	
	
	// get specific data using id 
	@GetMapping("/{id}")
	public ResponseEntity<Tests_Master> getTests_MasterDataById(@PathVariable("id") int id){
		
		Tests_Master tests_Master = tests_MasterService.getTests_MasterById(id);
		if(tests_Master == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(tests_Master, HttpStatus.FOUND);
	}
	
	
	// update specific data from Tests_Master
	@PutMapping("/{id}")
	public ResponseEntity<Tests_Master> updataSpecificTests_MasterData(@PathVariable("id") int id, @RequestBody Tests_MasterDto tests_MasterDto){
		
		Tests_Master tests_Master = tests_MasterService.getTests_MasterById(id);
		
		if(tests_Master == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		tests_Master.setTest_name(tests_MasterDto.getTest_name());
		tests_Master.setNormal_range(tests_MasterDto.getNormal_range());
		tests_Master.setUnit(tests_MasterDto.getUnit());
		
		// to get doctor id for show data
		Doctor doctor = doctorService.getDoctorById(tests_MasterDto.getDoctorid());
		
		tests_Master.setDoctorid(doctor);
		
		Tests_Master updateTests_Master = tests_MasterService.saveTests_Master(tests_Master);
		
		return new ResponseEntity<>(updateTests_Master, HttpStatus.OK);
	}
	
	// delete specific id from tests_master
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTests_MasterData(@PathVariable("id") int id){
		
		Tests_Master tests_Master = tests_MasterService.getTests_MasterById(id);
		
		if(tests_Master == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		tests_MasterService.deleteTests_MasterId(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
}
