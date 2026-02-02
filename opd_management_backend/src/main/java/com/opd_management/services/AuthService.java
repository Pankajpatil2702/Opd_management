    package com.opd_management.services;

import com.opd_management.dtos.LoginReq_Dto;
import com.opd_management.responce.JwtResponse;

public interface AuthService {
	
	// Doctor login method
    // Takes login request (email & password) and returns JWT response
    JwtResponse doctorLogin(LoginReq_Dto loginReq_Dto);

    // Admin login method
    // Validates admin credentials and generates JWT token
    JwtResponse adminLogin(LoginReq_Dto loginReq_Dto);

    // Reception login method
    // Authenticates reception user and returns JWT token
    JwtResponse receptionLogin(LoginReq_Dto loginReq_Dto);

}
