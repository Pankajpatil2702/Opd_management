package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Admin;

public interface AdminService {

	Admin saveAdmin(Admin admin);
	
	List<Admin> getAllAdmin();
	
	Admin getAdminById(int id);
	
	void deleteAdmin(int id);
	
	Admin getAdminByEmail(String email);
}
