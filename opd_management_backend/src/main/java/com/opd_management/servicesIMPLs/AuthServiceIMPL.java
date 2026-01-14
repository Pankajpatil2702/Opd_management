package com.opd_management.servicesIMPLs;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.opd_management.dtos.LoginRequest;
import com.opd_management.entities.Doctor;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.DoctorRepository;
import com.opd_management.responce.LoginResponse;
import com.opd_management.services.AuthService;

@Service
public class AuthServiceIMPL implements AuthService {

	
	private final DoctorRepository doctorRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	public  AuthServiceIMPL(DoctorRepository doctorRepository, PasswordEncoder passwordEncoder) {
		this.doctorRepository=doctorRepository;
		this.passwordEncoder=passwordEncoder;
	}
	
	@Override
	public LoginResponse login(LoginRequest request) {
		
		Doctor doctor = doctorRepository.findByEmail(request.getEmail())
				.orElseThrow( () -> new ResourseNotFoundException("Email not found.."));

		if(!passwordEncoder.matches(request.getPassword(), doctor.getPassword())) {
			
			throw new RuntimeException("Invalid password");
		}
		return new LoginResponse("Login successful!", doctor.getEmail());
	}

}
