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

 
@RestController
@RequestMapping("/auth")
public class AuthController {

	
	// Inject service layer to perform Auth-related operations
	@Autowired
	private  AuthService authService;
	
	
	/**
     * Doctor Login API
     * ----------------
     * URL  : POST /auth/login/doctor
     * Input: LoginReq_Dto (email, password)
     * Output: JwtResponse (JWT token + user info)
     *
     * This method validates the request body and
     * calls the service layer to authenticate a doctor.
     */
	@PostMapping("/login/doctor")
	public JwtResponse doctorLogin(@Valid @RequestBody LoginReq_Dto loginReq_Dto) {
		
		return authService.doctorLogin(loginReq_Dto);
	}
	
	
	/**
     * Admin Login API
     * ---------------
     * URL  : POST /auth/login/admin
     * Input: LoginReq_Dto (email, password)
     * Output: JwtResponse
     *
     * This method authenticates an admin user
     * and returns a JWT token if credentials are valid.
     */
	@PostMapping("/login/admin")
	public JwtResponse adminLogin(@Valid @RequestBody LoginReq_Dto loginReq_Dto) {
		
		return authService.adminLogin(loginReq_Dto);
	}
	
	
	/**
     * Reception Login API
     * -------------------
     * URL  : POST /auth/login/reception
     * Input: LoginReq_Dto (email, password)
     * Output: JwtResponse
     *
     * This method authenticates a reception user
     * and generates a JWT token on successful login.
     */
	@PostMapping("/login/reception")
	public JwtResponse receptionLogin(@Valid @RequestBody LoginReq_Dto loginReq_Dto) {
		
		return authService.receptionLogin(loginReq_Dto);
	}
}
