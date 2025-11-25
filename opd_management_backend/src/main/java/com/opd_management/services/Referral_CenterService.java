package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Referral_Center;

public interface Referral_CenterService {
	
	Referral_Center saveReferral_Center(Referral_Center referral_Center);
	
	List<Referral_Center> getAllReferral_Center();
	
	Referral_Center getReferral_CenterById(int id);
	
	void deleteReferral_CenterById(int id);

}
