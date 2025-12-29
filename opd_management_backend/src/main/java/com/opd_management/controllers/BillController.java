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
import com.opd_management.dtos.BillDto;
import com.opd_management.entities.Bill;
import com.opd_management.entities.Visit;
import com.opd_management.services.BillService;
import com.opd_management.services.VisitService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	private BillService billService ;
	
	@Autowired
	private VisitService visitService;
	
	
	// insert data into bill table
	@PostMapping("/")
	public ResponseEntity<Bill> saveBillFromTable(@Valid @RequestBody BillDto billDto){
		
		Bill bill = new Bill();
		bill.setConsultation_fee(billDto.getConsultation_fee());
		bill.setPayment_status(billDto.getPayment_status());
		bill.setPayment_mode(billDto.getPayment_mode());
		bill.setConcession(billDto.getConcession());
		bill.setPaid_amount(billDto.getPaid_amount());
		bill.setTotal_amount(billDto.getTotal_amount());
		bill.setPending_amount(billDto.getPending_amount());
		bill.setCreated_at(billDto.getCreated_at());
		
		// To Visit By id data or show all info
		Visit visit = visitService.getVisitByID(billDto.getVisitid());
		
		bill.setVisitid(visit);
		
		Bill saveBill = billService.saveBill(bill);
		
		return new ResponseEntity<>(saveBill , HttpStatus.CREATED);
	}
	
	
	// get all data from bill table
	@GetMapping("/")
	public ResponseEntity<List<Bill>> getAllBillFromTable(){
		
		List<Bill> bill = billService.getAllBill();
		
		if(bill == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(bill , HttpStatus.FOUND);
				
	}
	
	// get specific data from table using id
	@GetMapping("/{id}")
	public ResponseEntity<Bill> getDataFromBillTableUsingId(@PathVariable("id") int id){
		
		Bill bill = billService.getBillById(id);
		if(bill == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(bill, HttpStatus.FOUND);
	}
	
	
	// update specific id from bill table
	@PutMapping("/{id}")
	public ResponseEntity<Bill> updateSpecificIdFromBillTable(@PathVariable("id") int id,@Valid  @RequestBody BillDto billDto){
		
		Bill bill = billService.getBillById(id);
		if(bill == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		
		bill.setConsultation_fee(billDto.getConsultation_fee());
		bill.setPayment_status(billDto.getPayment_status());
		bill.setPayment_mode(billDto.getPayment_mode());
		bill.setConcession(billDto.getConcession());
		bill.setPaid_amount(billDto.getPaid_amount());
		bill.setTotal_amount(billDto.getTotal_amount());
		bill.setPending_amount(billDto.getPending_amount());
		bill.setCreated_at(billDto.getCreated_at());
		
		// To Visit By id data or show all info
 
		Visit visit = visitService.getVisitByID(billDto.getVisitid());
		
		bill.setVisitid(visit);
		
		Bill updateBill = billService.saveBill(bill);
		
		return new ResponseEntity<>(updateBill, HttpStatus.OK);
	}
	
	// delete specific id from table 
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSpecificIdFromBill(@PathVariable("id") int id){
		
		Bill bill = billService.getBillById(id);
		if(bill == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		billService.deleteBillId(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}

}
