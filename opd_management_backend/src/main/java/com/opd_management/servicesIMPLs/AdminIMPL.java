package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Admin;
import com.opd_management.exception.DataBaseException;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.AdminRepository;
import com.opd_management.services.AdminService;

@Service
public class AdminIMPL implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin saveAdmin(Admin admin) {
		
		try {
			return adminRepository.save(admin);
			
		} catch (Exception e) {
			
			throw new DataBaseException("Failed to save admin due to database error");
			
		}
	}

	@Override
	public List<Admin> getAllAdmin() {
		
		try {
			
			return adminRepository.findAll();
			
		} catch (Exception e) {
			
			throw new DataBaseException("Failed to find admin due to database error");
		}
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return adminRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Admin Not Found With id: " + id) );
	}

	@Override
	public void deleteAdmin(int id) {
		// TODO Auto-generated method stub
		try {
			
			adminRepository.deleteById(id);
			
		} catch (Exception e) {
			
			throw new DataBaseException("Failed to delete admin due to database error.");
		}
	}

	@Override
	public Admin getAdminByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			
			return adminRepository.findByEmail(email).orElseThrow(() -> 
			new ResourseNotFoundException("Admin not found with email: " + email));
		} catch (Exception e) {

			throw new DataBaseException("Failed to get admin due to database error");              
		}
	}



}
