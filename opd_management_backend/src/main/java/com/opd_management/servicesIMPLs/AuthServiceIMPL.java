   package com.opd_management.servicesIMPLs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.opd_management.dtos.LoginReq_Dto;
import com.opd_management.entities.Admin;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Reception;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.AdminRepository;
import com.opd_management.repositories.DoctorRepository;
import com.opd_management.repositories.ReceptionRepository;
import com.opd_management.responce.AdminResponce;
import com.opd_management.responce.DoctorResponce;
import com.opd_management.responce.JwtResponse;
import com.opd_management.responce.ReceptionResponce;
import com.opd_management.security.JwtUtil;
import com.opd_management.services.AuthService;

@Service
public class AuthServiceIMPL implements AuthService {

	
	// Inject JPA layer to perform doctor-related operations
	@Autowired
	private DoctorRepository doctorRepository;
	
	// Inject JPA layer to perform admin-related operations
	@Autowired
	private AdminRepository adminRepository;
	
	// Inject JPA layer to perform reception-related operations
	@Autowired
	private ReceptionRepository receptionRepository;
	
	// Inject security layer to  decoded pass & verify.
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	/**
	 * AuthServiceIMPL
	 * ----------------
	 * This service class contains the business logic
	 * for authenticating Doctor, Admin, and Reception users.
	 */
	@Override
	public JwtResponse doctorLogin(LoginReq_Dto loginReq_Dto) {

	    // 1. Fetch doctor from database using email
	    //    If email is not found, throw custom exception
	    Doctor doctor = doctorRepository.findByEmail(loginReq_Dto.getEmail())
	            .orElseThrow(() -> new ResourseNotFoundException("Email Not Found"));

	    // 2. Verify password using PasswordEncoder
	    //    matches(rawPassword, encodedPassword)
	    if (!passwordEncoder.matches(loginReq_Dto.getPassword(), doctor.getPassword())) {
	        throw new RuntimeException("Invalid Password");
	    }

	    // 3. Map Doctor entity to DoctorResponse DTO
	    //    (Never return entity directly to client)
	    DoctorResponce doctorResponce = new DoctorResponce();
	    doctorResponce.setId(doctor.getId());
	    doctorResponce.setName(doctor.getName());
	    doctorResponce.setEmail(doctor.getEmail());
	    doctorResponce.setAddress(doctor.getAddress());
	    doctorResponce.setClinic_name(doctor.getClinic_name());
	    doctorResponce.setMobileNo(doctor.getMobileNo());
	    doctorResponce.setQualification(doctor.getQualification());
	    doctorResponce.setSpecialization(doctor.getSpecialization());

	    // 4. Generate JWT token using email and role
	    String token = jwtUtil.generateToken(doctor.getEmail(), doctor.getRole());

	    // 5. Return JWT response containing token, role, and doctor details
	    return new JwtResponse(token, doctor.getRole(), doctorResponce);
	}


	@Override
	public JwtResponse adminLogin(LoginReq_Dto loginReq_Dto) {

	    // 1. Fetch admin details using email
	    Admin admin = adminRepository.findByEmail(loginReq_Dto.getEmail())
	            .orElseThrow(() -> new ResourseNotFoundException("Email Not Found"));

	    // 2. Validate admin password
	    if (!passwordEncoder.matches(loginReq_Dto.getPassword(), admin.getPassword())) {
	        throw new RuntimeException("Invalid Password");
	    }

	    // 3. Generate JWT token for admin
	    String token = jwtUtil.generateToken(admin.getEmail(), admin.getRole());

	    // 4. Map Admin entity to AdminResponse DTO
	    AdminResponce adminResponce = new AdminResponce();
	    adminResponce.setId(admin.getId());
	    adminResponce.setEmail(admin.getEmail());
	    adminResponce.setName(admin.getName());
	    adminResponce.setMobileNo(admin.getMobileNo());

	    // 5. Return token, role, and admin datax
	    return new JwtResponse(token, admin.getRole(), adminResponce);
	}


	@Override
	public JwtResponse receptionLogin(LoginReq_Dto loginReq_Dto) {

	    // 1. Fetch reception details using email
	    Reception reception = receptionRepository.findByEmail(loginReq_Dto.getEmail());

	    // 2. Validate reception password
	    if (!passwordEncoder.matches(loginReq_Dto.getPassword(), reception.getPassword())) {
	        throw new RuntimeException("Invalid Password");
	    }

	    // 3. Map Reception entity to ReceptionResponse DTO
	    ReceptionResponce receptionResponce = new ReceptionResponce();
	    receptionResponce.setId(reception.getId());
	    receptionResponce.setDoctorid(reception.getDoctorid().getId());
	    receptionResponce.setEmail(reception.getEmail());
	    receptionResponce.setName(reception.getName());
	    receptionResponce.setMobile_no(reception.getMobile_no());
	    receptionResponce.setShift(reception.getShift());

	    // 4. Generate JWT token for reception user
	    String token = jwtUtil.generateToken(reception.getEmail(), reception.getRole());

	    // 5. Return JWT response
	    return new JwtResponse(token, reception.getRole(), receptionResponce);
	}

	
	
}
