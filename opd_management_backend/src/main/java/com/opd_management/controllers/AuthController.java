package com.opd_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opd_management.dtos.LoginRequest;
import com.opd_management.responce.LoginResponse;
import com.opd_management.services.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private  AuthService authService;
	
	@PostMapping("/login")
	public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {
		
		return authService.login(loginRequest);
	}
}
