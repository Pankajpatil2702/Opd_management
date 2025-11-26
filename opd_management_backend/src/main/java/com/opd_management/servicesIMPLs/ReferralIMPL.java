package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Referral;
import com.opd_management.repositories.ReferralRepository;
import com.opd_management.services.ReferralService;

@Service
public class ReferralIMPL implements ReferralService {

	@Autowired
	private ReferralRepository referralRepository;
	
	@Override
	public Referral saveReferral(Referral referral) {
		// TODO Auto-generated method stub
		return referralRepository.save(referral);
	}

	@Override
	public List<Referral> getAllReferral() {
		// TODO Auto-generated method stub
		return referralRepository.findAll();
	}

	@Override
	public Referral getReferralById(int id) {
		// TODO Auto-generated method stub
		return referralRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteReferralById(int id) {
		// TODO Auto-generated method stub
		referralRepository.deleteById(id);
	}

}
