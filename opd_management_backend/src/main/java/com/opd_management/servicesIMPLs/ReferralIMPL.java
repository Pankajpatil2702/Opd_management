package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Referral;
import com.opd_management.exception.DataBaseException;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.ReferralRepository;
import com.opd_management.services.ReferralService;

@Service
public class ReferralIMPL implements ReferralService {

	@Autowired
	private ReferralRepository referralRepository;
	
	@Override
	public Referral saveReferral(Referral referral) {
		
		try {
			
			return referralRepository.save(referral);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to save due to database error");
		}
	}

	@Override
	public List<Referral> getAllReferral() {
		
		try {
			
			return referralRepository.findAll();
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to find referral due to database error");
		}
	}

	@Override
	public Referral getReferralById(int id) {
		// TODO Auto-generated method stub
		return referralRepository.findById(id).orElseThrow(() -> new
				ResourseNotFoundException("referral not found with id:" + id));
	}

	@Override
	public void deleteReferralById(int id) {
		
		try {
			
			referralRepository.deleteById(id);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to delete referral due to database error");
		}
	}

}
