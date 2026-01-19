package com.opd_management.services;

import com.opd_management.dtos.LoginReq_Dto;
import com.opd_management.responce.JwtResponse;

public interface AuthService {
	
	JwtResponse doctorLogin(LoginReq_Dto loginReq_Dto);
	JwtResponse adminLogin(LoginReq_Dto loginReq_Dto);
	JwtResponse receptionLogin(LoginReq_Dto loginReq_Dto);

}
