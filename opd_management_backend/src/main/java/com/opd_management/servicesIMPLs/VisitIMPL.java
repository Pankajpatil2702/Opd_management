package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Visit;
import com.opd_management.repositories.VisitRepository;
import com.opd_management.services.VisitService;

@Service
public class VisitIMPL implements VisitService {

	@Autowired
	private VisitRepository visitRepository;
	
	@Override
	public Visit saveVisit(Visit visit) {
		// TODO Auto-generated method stub
		return visitRepository.save(visit);
	}

	@Override
	public List<Visit> getAllVisit() {
		// TODO Auto-generated method stub
		return visitRepository.findAll();
	}

	@Override
	public Visit getVisitByID(int id) {
		// TODO Auto-generated method stub
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteVisiteId(int id) {
		// TODO Auto-generated method stub
		visitRepository.deleteById(id);
	}

}
