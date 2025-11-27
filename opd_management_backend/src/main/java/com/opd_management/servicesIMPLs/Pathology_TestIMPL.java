package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Pathology_Test;
import com.opd_management.repositories.Pathology_TestRepository;
import com.opd_management.services.Pathology_TestService;

@Service
public class Pathology_TestIMPL implements Pathology_TestService {

	@Autowired
	private Pathology_TestRepository pathology_TestRepository;
	
	@Override
	public Pathology_Test savePathology_Test(Pathology_Test pathology_Test) {
		// TODO Auto-generated method stub
		return pathology_TestRepository.save(pathology_Test);
	}

	@Override
	public List<Pathology_Test> getAllPathology_Test() {
		// TODO Auto-generated method stub
		return pathology_TestRepository.findAll();
	}

	@Override
	public Pathology_Test getPathologyById(int id) {
		// TODO Auto-generated method stub
		return pathology_TestRepository.findById(id).orElse(null);
	}

	@Override
	public void deletePathologyId(int id) {
		// TODO Auto-generated method stub
		pathology_TestRepository.deleteById(id);
	}

}
