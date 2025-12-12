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

import com.opd_management.dtos.ReceptionDto;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Reception;
import com.opd_management.services.DoctorService;
import com.opd_management.services.ReceptionService;

@RestController
@RequestMapping("/reception")
public class ReceptionController {

	@Autowired
	private ReceptionService receptionService;
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/")
	public ResponseEntity<Reception> saveDataFromReception(@RequestBody ReceptionDto receptionDto){
		
		Reception reception = new Reception();
		
		reception.setName(receptionDto.getName());
		reception.setEmail(receptionDto.getEmail());
		reception.setMobile_no(receptionDto.getMobile_no());
		reception.setShift(receptionDto.getShift());
		reception.setPassword(receptionDto.getPassword());
		
		Doctor doctor = doctorService.getDoctorById(receptionDto.getDoctorid());
		
		reception.setDoctorid(doctor);
		
		Reception saveReception = receptionService.saveReception(reception);
		
		return new ResponseEntity<>(saveReception, HttpStatus.CREATED);
	}
	
	// get all data reception table
	@GetMapping("/")
	public ResponseEntity<List<Reception>> getAllDataFromReceptionTable(){
		
		List<Reception> reception = receptionService.getAllReceptions();
		if(reception == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new  ResponseEntity<>(reception , HttpStatus.FOUND);		
	}
	
	// get reception data using id
	@GetMapping("/{id}")
	public ResponseEntity<Reception> getReceptionById(@PathVariable("id") int id){
		
		Reception reception = receptionService.getReceptionById(id);
		
		if(reception == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(reception , HttpStatus.FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Reception> updateReceptionTableUsingId(@PathVariable("id") int id,@RequestBody ReceptionDto receptionDto){
		
		Reception reception = receptionService.getReceptionById(id);
		if(reception == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		reception.setName(receptionDto.getName());
		reception.setEmail(receptionDto.getEmail());
		reception.setMobile_no(receptionDto.getMobile_no());
		reception.setShift(receptionDto.getShift());
		reception.setPassword(receptionDto.getPassword());
		
		Doctor doctor = doctorService.getDoctorById(receptionDto.getDoctorid());
		
		reception.setDoctorid(doctor);
		
		Reception updateReception = receptionService.saveReception(reception);
		
		return new ResponseEntity<>(updateReception , HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReceptionUsingId(@PathVariable("id") int id){
		
		Reception reception = receptionService.getReceptionById(id);
		
		if(reception == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		receptionService.deleteReceptionById(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
}
