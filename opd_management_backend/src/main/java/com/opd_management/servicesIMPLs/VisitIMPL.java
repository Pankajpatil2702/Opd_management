package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.opd_management.entities.Visit;
import com.opd_management.exception.DataBaseException;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.VisitRepository;
import com.opd_management.services.VisitService;

@Service
public class VisitIMPL implements VisitService {

	@Autowired
	private VisitRepository visitRepository;
	
	@Override
	public Visit saveVisit(Visit visit) {
		
		try {
			
			return visitRepository.save(visit);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to save visit due to database error");
		}
	}

	@Override
	public List<Visit> getAllVisit() {
		
		try {
			
			return visitRepository.findAll();
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to find visits due to database error");
		}
	}

	@Override
	public Visit getVisitByID(int id) {
		// TODO Auto-generated method stub
		return visitRepository.findById(id).orElseThrow(() -> new 
				ResourseNotFoundException("visit not found with id: "+ id));
	}

	@Override
	public void deleteVisiteId(int id) {
		
		try {
			
			visitRepository.deleteById(id);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to delete visit due to database error");
		}
	}

}
