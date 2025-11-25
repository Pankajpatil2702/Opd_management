package com.opd_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		Doctor doctor = doctorService.getDoctorById(tests_MasterDto.getDoctorid());
		
		tests_Master.setDoctorid(doctor);
		
		Tests_Master saveTests_Master = tests_MasterService.saveTests_Master(tests_Master);
		
		return new ResponseEntity<>(saveTests_Master, HttpStatus.CREATED);
				
	}
	
}
