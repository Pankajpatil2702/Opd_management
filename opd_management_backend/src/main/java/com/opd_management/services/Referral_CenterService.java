package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Referral_Center;

public interface Referral_CenterService {
	
	// save/insert data from referral_cneter
	Referral_Center saveReferral_Center(Referral_Center referral_Center);
	
	// get all data from referral_cneter
	List<Referral_Center> getAllReferral_Center();
	
	// get specific data using id from referral_cneter
	Referral_Center getReferral_CenterById(int id);
	
	// delete specific data using from referral_cneter
	void deleteReferral_CenterById(int id);

}
