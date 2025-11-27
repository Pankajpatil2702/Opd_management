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

import com.opd_management.dtos.Visit_ReportDto;
import com.opd_management.entities.Visit;
import com.opd_management.entities.Visit_Report;
import com.opd_management.services.VisitService;
import com.opd_management.services.Visit_ReportService;

@RestController
@RequestMapping("/visitreport")
public class Visit_ReportController {
	
	@Autowired
	private Visit_ReportService visit_ReportService;
	
	@Autowired
	private VisitService visitService;
	
	
	// insert data into visit_report table
	@PostMapping("/")
	public ResponseEntity<Visit_Report> saveVisit_ReportEntity(@RequestBody Visit_ReportDto visit_ReportDto){
		
		Visit_Report visit_Report  = new Visit_Report();
		
		visit_Report.setFile_name(visit_ReportDto.getFile_name());
		visit_Report.setFile_url(visit_ReportDto.getFile_url());
		visit_Report.setFile_type(visit_ReportDto.getFile_type());
		visit_Report.setCreated_at(visit_ReportDto.getCreated_at());
		
		Visit visit = visitService.getVisitByID(visit_ReportDto.getVisitid());
		
		visit_Report.setVisitid(visit);
		
		Visit_Report saveVisit_Report = visit_ReportService.saveVisit_Report(visit_Report);
		
		return new ResponseEntity<>(saveVisit_Report, HttpStatus.CREATED);
				
	}
	
	// get all data form visit_report 
	@GetMapping("/")
	public ResponseEntity<List<Visit_Report>> getAllDataFromVisit_Report(){
		
		List<Visit_Report> visit_Report = visit_ReportService.getAllVisit_Report();
		if(visit_Report == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(visit_Report, HttpStatus.FOUND);
	}
	
	
	// get specific data from visit_report using id
	@GetMapping("/{id}")
	public ResponseEntity<Visit_Report> getSpecificDataFromVisit_ReportUsingId(@PathVariable("id") int id){
		
		Visit_Report visit_Report = visit_ReportService.getVisit_ReportById(id);
		if(visit_Report == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					
		}
		return new ResponseEntity<>(visit_Report, HttpStatus.FOUND);
	}
	
	// update specific id from visit_report table
	@PutMapping("/{id}")
	public ResponseEntity<Visit_Report> upateSpecificDataFromVisit_ReportUsingId(@PathVariable("id") int id, @RequestBody Visit_ReportDto visit_ReportDto){
		
		Visit_Report visit_Report = visit_ReportService.getVisit_ReportById(id);
		if(visit_Report == null) {
			
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
		
		visit_Report.setFile_name(visit_ReportDto.getFile_name());
		visit_Report.setFile_url(visit_ReportDto.getFile_url());
		visit_Report.setFile_type(visit_ReportDto.getFile_type());
		visit_Report.setCreated_at(visit_ReportDto.getCreated_at());
		
		Visit visit = visitService.getVisitByID(visit_ReportDto.getVisitid());
		
		visit_Report.setVisitid(visit);
		
		Visit_Report updateVisit_Report = visit_ReportService.saveVisit_Report(visit_Report);
		
		return new ResponseEntity<>(updateVisit_Report, HttpStatus.OK);
		
	}
	
	// delete specific id from visit_report table
	@DeleteMapping("/{id}")
	public ResponseEntity<Visit_Report> deleteSpecificIdFromVisit_Report(@PathVariable("id") int id){
		
		Visit_Report visit_Report = visit_ReportService.getVisit_ReportById(id);
		if(visit_Report == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		visit_ReportService.deleteVisit_ReportId(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		
	}
	

}
