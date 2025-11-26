package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Referral;

public interface ReferralService {
	
	Referral saveReferral(Referral referral);
	
	List<Referral> getAllReferral();
	
	Referral getReferralById(int id);
	
	void deleteReferralById(int id);

}
