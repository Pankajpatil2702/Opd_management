package com.opd_management.servicesIMPLs;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.opd_management.entities.Pathology_Test;
import com.opd_management.exception.DataBaseException;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.Pathology_TestRepository;
import com.opd_management.services.Pathology_TestService;

@Service
public class Pathology_TestIMPL implements Pathology_TestService {

	@Autowired
	private Pathology_TestRepository pathology_TestRepository;
	
	@Override
	public Pathology_Test savePathology_Test(Pathology_Test pathology_Test) {
		
		try {
			
			return pathology_TestRepository.save(pathology_Test);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to save pathology test due to database error");
		}
	}

	@Override
	public List<Pathology_Test> getAllPathology_Test() {
		
		try {
			
			return pathology_TestRepository.findAll();
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to find pathology test data due to database error");
		}
		
	}

	@Override
	public Pathology_Test getPathologyById(int id) {
		// TODO Auto-generated method stub
		return pathology_TestRepository.findById(id).orElseThrow(() -> new
				ResourseNotFoundException("pathology test not found with id:" + id));
	}

	@Override
	public void deletePathologyId(int id) {
		
		try {
			
			pathology_TestRepository.deleteById(id);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to delete pathology test due to database error");
		}
	}

}
