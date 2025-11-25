package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Referral_Center;
import com.opd_management.repositories.Referral_CenterRepository;
import com.opd_management.services.Referral_CenterService;

@Service
public class Referral_CenterIMPL implements Referral_CenterService {

	@Autowired
	private Referral_CenterRepository referral_CenterRepository;
	
	@Override
	public Referral_Center saveReferral_Center(Referral_Center referral_Center) {
		// TODO Auto-generated method stub
		return referral_CenterRepository.save(referral_Center);
	}

	@Override
	public List<Referral_Center> getAllReferral_Center() {
		// TODO Auto-generated method stub
		return referral_CenterRepository.findAll();
	}

	@Override
	public Referral_Center getReferral_CenterById(int id) {
		// TODO Auto-generated method stub
		return referral_CenterRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteReferral_CenterById(int id) {
		// TODO Auto-generated method stub
		referral_CenterRepository.deleteById(id);
	}

}
