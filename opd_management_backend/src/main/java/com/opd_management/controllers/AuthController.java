package com.opd_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opd_management.dtos.LoginReq_Dto;
import com.opd_management.responce.JwtResponse;
import com.opd_management.services.AuthService;

import jakarta.validation.Valid;

// 
@RestController
@RequestMapping("/auth")
public class AuthController {

	
	// Inject service layer to perform Auth-related operations
	@Autowired
	private  AuthService authService;
	
	@PostMapping("/login/doctor")
	public JwtResponse doctorLogin(@Valid @RequestBody LoginReq_Dto loginReq_Dto) {
		
		return authService.doctorLogin(loginReq_Dto);
	}
	
	@PostMapping("/login/admin")
	public JwtResponse adminLogin(@Valid @RequestBody LoginReq_Dto loginReq_Dto) {
		
		return authService.adminLogin(loginReq_Dto);
	}
	
	@PostMapping("/login/reception")
	public JwtResponse receptionLogin(@Valid @RequestBody LoginReq_Dto loginReq_Dto) {
		
		return authService.receptionLogin(loginReq_Dto);
	}
}
