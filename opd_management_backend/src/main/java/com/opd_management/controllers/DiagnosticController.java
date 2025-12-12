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

import com.opd_management.dtos.DiagnosticDto;
import com.opd_management.entities.Diagnostic;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Visit;
import com.opd_management.services.DiagnosticService;
import com.opd_management.services.DoctorService;
import com.opd_management.services.VisitService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/diagnostic")
public class DiagnosticController {

	@Autowired
	private DiagnosticService diagnosticService;
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private DoctorService doctorService;
	
	
	// insert Data Into Diagnostic Table
	@PostMapping("/")
	public ResponseEntity<Diagnostic> saveDiagnosticEntity(@Valid @RequestBody DiagnosticDto diagnosticDto){
		
		Diagnostic diagnostic = new Diagnostic();
		diagnostic.setName(diagnosticDto.getName());
		diagnostic.setCreated_at(diagnosticDto.getCreated_at());
		
		// to get visit id or show info  
		Visit visit =visitService.getVisitByID(diagnosticDto.getVisitid());
		
		// to get doctor id or show info
		Doctor doctor = doctorService.getDoctorById(diagnosticDto.getDoctorid());
		
		diagnostic.setDoctorid(doctor);
		diagnostic.setVisitid(visit);
		
		Diagnostic saveDiagnostic = diagnosticService.saveDiagnostic(diagnostic);
		
		return new ResponseEntity<>(saveDiagnostic, HttpStatus.CREATED);
	}
	
	
	// Get Diagnostic Data From Table
	@GetMapping("/")
	public ResponseEntity<List<Diagnostic>> getAllDiagnosticData(){
		
		List<Diagnostic> diagnostic = diagnosticService.getAllDiagnostic();
		
		if(diagnostic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(diagnostic, HttpStatus.FOUND);
		
	}
	
	// Get Diagnostic Data Using "id"
	@GetMapping("/{id}")
	public ResponseEntity<Diagnostic> getDiagnosticDataById(@PathVariable("id") int id){
		
		Diagnostic diagnostic = diagnosticService.getDiagnosticById(id);
		if(diagnostic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(diagnostic, HttpStatus.FOUND);
	}
	
	// Update Specific Data From Diagnostic Table
	@PutMapping("/{id}")
	public ResponseEntity<Diagnostic> updateDiagnosticDataFromTable(@PathVariable("id") int id,@Valid  @RequestBody DiagnosticDto diagnosticDto){
		
		Diagnostic diagnostic = diagnosticService.getDiagnosticById(id);
		if(diagnostic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		diagnostic.setName(diagnosticDto.getName());
		diagnostic.setCreated_at(diagnosticDto.getCreated_at());
		
		// to get visit id or show info
		Visit visit = visitService.getVisitByID(diagnosticDto.getVisitid());
				
		// to get doctor id or show info
		Doctor doctor = doctorService.getDoctorById(diagnosticDto.getDoctorid());
		
		diagnostic.setDoctorid(doctor);
		
		diagnostic.setVisitid(visit);
		
		Diagnostic updateDiagnostic = diagnosticService.saveDiagnostic(diagnostic);
		
		return new ResponseEntity<>(updateDiagnostic, HttpStatus.OK);
	}
	
	//Delete Specific Id From Diagnostic Table
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSpecificIdFromTable(@PathVariable("id") int id){
		
		Diagnostic diagnostic = diagnosticService.getDiagnosticById(id);
		if(diagnostic == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		diagnosticService.deleteDiagnostic(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	
}
