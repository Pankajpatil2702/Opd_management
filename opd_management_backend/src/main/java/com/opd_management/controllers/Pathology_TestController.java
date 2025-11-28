package com.opd_management.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opd_management.dtos.Pathology_TestDto;
import com.opd_management.entities.Pathology_Test;
import com.opd_management.entities.Tests_Master;
import com.opd_management.entities.Visit;
import com.opd_management.services.Pathology_TestService;
import com.opd_management.services.Tests_MasterService;
import com.opd_management.services.VisitService;

@RestController
@RequestMapping("/pathologytest")
public class Pathology_TestController {
	
	private static final HttpStatus ResponseEntity = null;

	@Autowired
	private Pathology_TestService pathology_TestService;
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private Tests_MasterService tests_MasterService;
	
	// insert data into pathology_test table
	@PostMapping("/")
	public ResponseEntity<Pathology_Test> savePathology_TestEntity(@RequestBody Pathology_TestDto pathology_TestDto){
		
		Pathology_Test pathology_Test = new Pathology_Test();
		
		pathology_Test.setResult(pathology_TestDto.getResult());
		pathology_Test.setRemarks(pathology_TestDto.getRemarks());
		pathology_Test.setReport_file(pathology_TestDto.getReport_file());
		pathology_Test.setCreated_at(pathology_TestDto.getCreated_at());
		
		Visit visit = visitService.getVisitByID(pathology_TestDto.getVisitid());
		pathology_Test.setVisitid(visit);
		
		Tests_Master tests_Master = tests_MasterService.getTests_MasterById(pathology_TestDto.getTestMasterid());
		pathology_Test.setTestMasterid(tests_Master);
		
		Pathology_Test savePathology_Test = pathology_TestService.savePathology_Test(pathology_Test);
		
		return new ResponseEntity<>(savePathology_Test, HttpStatus.CREATED);
	}
	
	// get all data from pathology_test
	@GetMapping("/")
	public ResponseEntity<List<Pathology_Test>> getAllPathology_TestData(){
		
		List<Pathology_Test> pathology_Test = pathology_TestService.getAllPathology_Test();
		if(pathology_Test == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pathology_Test, HttpStatus.FOUND);
	}
	
	// get specific data from pathology_test using id
	@GetMapping("/{id}")
	public ResponseEntity<Pathology_Test> getSpecificDataFromPathology_TestUsingId(@PathVariable("id") int id){
		
		Pathology_Test pathology_Test = pathology_TestService.getPathologyById(id);
		if(pathology_Test == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<>(pathology_Test, HttpStatus.FOUND);
	}
	
	// update data from pathology_Test using id
	@PutMapping("/{id}")
	public ResponseEntity<Pathology_Test> updateDataFromPathology_Test(@PathVariable("id") int id, @RequestBody Pathology_TestDto pathology_TestDto){
		
		Pathology_Test pathology_Test = pathology_TestService.getPathologyById(id);
		if(pathology_Test == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		pathology_Test.setResult(pathology_TestDto.getResult());
		pathology_Test.setRemarks(pathology_TestDto.getRemarks());
		pathology_Test.setReport_file(pathology_TestDto.getReport_file());
		pathology_Test.setCreated_at(pathology_TestDto.getCreated_at());
		
		Visit visit = visitService.getVisitByID(pathology_TestDto.getVisitid());
		pathology_Test.setVisitid(visit);
		
		Tests_Master tests_Master = tests_MasterService.getTests_MasterById(pathology_TestDto.getTestMasterid());
		pathology_Test.setTestMasterid(tests_Master);
		
		Pathology_Test updatePathology_Test = pathology_TestService.savePathology_Test(pathology_Test);
		
		return new ResponseEntity<>(updatePathology_Test, HttpStatus.OK);
	}
	
	
	// delete specific id from pathology_test 
	public ResponseEntity<Void> deleteSpecificIdFromPathology_Test(@PathVariable("id") int id){
		
		Pathology_Test pathology_Test = pathology_TestService.getPathologyById(id);
		if(pathology_Test == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		pathology_TestService.deletePathologyId(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		
	}

}
