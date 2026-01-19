package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Admin;
import com.opd_management.repositories.AdminRepository;
import com.opd_management.services.AdminService;

@Service
public class AdminIMPL implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return adminRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteAdmin(int id) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(id);
	}

	@Override
	public Admin getAdminByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}



}
