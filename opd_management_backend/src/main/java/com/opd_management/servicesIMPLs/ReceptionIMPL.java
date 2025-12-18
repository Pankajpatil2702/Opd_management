   package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Reception;
import com.opd_management.repositories.ReceptionRepository;
import com.opd_management.services.ReceptionService;

@Service
public class ReceptionIMPL implements ReceptionService {

	@Autowired
	private ReceptionRepository receptionRepository;
	@Override
	public Reception saveReception(Reception reception) {
		// TODO Auto-generated method stub
		return receptionRepository.save(reception);
	}

	@Override
	public List<Reception> getAllReceptions() {
		// TODO Auto-generated method stub
		return receptionRepository.findAll();
	}

	@Override
	public Reception getReceptionById(int id) {
		// TODO Auto-generated method stub
		return receptionRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteReceptionById(int id) {
		// TODO Auto-generated method stub
		receptionRepository.deleteById(id);
		
	}

}
