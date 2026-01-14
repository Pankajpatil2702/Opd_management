package com.opd_management.services;

import com.opd_management.dtos.LoginRequest;
import com.opd_management.responce.LoginResponse;

public interface AuthService {
	
	LoginResponse login(LoginRequest request);

}
