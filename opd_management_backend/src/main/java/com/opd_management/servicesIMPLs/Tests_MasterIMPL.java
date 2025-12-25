package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Tests_Master;
import com.opd_management.exception.DataBaseException;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.Tests_MasterRepository;
import com.opd_management.services.Tests_MasterService;

@Service
public class Tests_MasterIMPL implements Tests_MasterService {

	@Autowired
	private Tests_MasterRepository tests_MasterRepository;
	
	@Override
	public Tests_Master saveTests_Master(Tests_Master tests_Master) {
		
		try {
			
			return tests_MasterRepository.save(tests_Master);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to save tests master due to database error");
		}
	}

	@Override
	public List<Tests_Master> getAllTests_Master() {
		
		try {
			
			return tests_MasterRepository.findAll();
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to find tests master due to database error");
		}
	}

	@Override
	public Tests_Master getTests_MasterById(int id) {
		
		return tests_MasterRepository.findById(id).orElseThrow(() -> new
				ResourseNotFoundException("test master not found with id: " + id));
	}

	@Override
	public void deleteTests_MasterId(int id) {
		
		try {
			
			tests_MasterRepository.deleteById(id);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to delete tests master due to database error");
		}
	}

}
