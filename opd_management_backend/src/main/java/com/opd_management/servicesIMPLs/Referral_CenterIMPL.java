package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Referral_Center;
import com.opd_management.exception.DataBaseException;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.Referral_CenterRepository;
import com.opd_management.services.Referral_CenterService;

@Service
public class Referral_CenterIMPL implements Referral_CenterService {

	@Autowired
	private Referral_CenterRepository referral_CenterRepository;
	
	@Override
	public Referral_Center saveReferral_Center(Referral_Center referral_Center) {
		
		try {
			
			return referral_CenterRepository.save(referral_Center);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to save referral center due to database error");
		}
	}

	@Override
	public List<Referral_Center> getAllReferral_Center() {
		
		try {
			
			return referral_CenterRepository.findAll();
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to find referral center due to database error");
		}
	}

	@Override
	public Referral_Center getReferral_CenterById(int id) {
		// TODO Auto-generated method stub
		return referral_CenterRepository.findById(id).orElseThrow(() -> new 
				ResourseNotFoundException("referral conter not found with id: " + id));
	}

	@Override
	public void deleteReferral_CenterById(int id) {
		
		try {
			
			referral_CenterRepository.deleteById(id);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to delete due to database error");
		}
	}

}
