package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Referral;

public interface ReferralService {
	// save/insert data into referral
	Referral saveReferral(Referral referral);
	
	// get all data from referral
	List<Referral> getAllReferral();
	
	// to get specific data using id from referral
	Referral getReferralById(int id);
	
	// delete specific data using id from referral
	void deleteReferralById(int id);

}
