   package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Reception;
import com.opd_management.exception.DataBaseException;
import com.opd_management.exception.DuplicateResourceException;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.ReceptionRepository;
import com.opd_management.services.ReceptionService;

@Service
public class ReceptionIMPL implements ReceptionService {

	@Autowired
	private ReceptionRepository receptionRepository;
	@Override
	public Reception saveReception(Reception reception) {
		
		try {
			try {
			
				receptionRepository.existByEmail(reception.getEmail());
		}
		catch(Exception e) {
			
			throw new DuplicateResourceException("reception with email" + reception.getEmail() + "already exists");
		}
			return receptionRepository.save(reception);
			
		} catch(Exception e) {
			throw new DataBaseException("Failed to save reception due to database error");
		}
	}

	@Override
	public List<Reception> getAllReceptions() {
		
		try {
			
			return receptionRepository.findAll();
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to find reception due to database error");
		}
	}

	@Override
	public Reception getReceptionById(int id) {
		
		return receptionRepository.findById(id).orElseThrow(() -> new
				ResourseNotFoundException("reception id not found with id: " + id));
	}

	@Override
	public void deleteReceptionById(int id) {
		
		try {
			
			receptionRepository.deleteById(id);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to delete due to database error");
		}
		
	}

}
