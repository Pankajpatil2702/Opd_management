package com.opd_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opd_management.dtos.EmailRequest;
import com.opd_management.services.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest){
		
		String response = emailService.sendEmail(emailRequest);
		
		return ResponseEntity.ok(response);
	}

}
