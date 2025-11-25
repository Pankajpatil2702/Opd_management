package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Tests_Master;
import com.opd_management.repositories.Tests_MasterRepository;
import com.opd_management.services.Tests_MasterService;

@Service
public class Tests_MasterIMPL implements Tests_MasterService {

	@Autowired
	private Tests_MasterRepository tests_MasterRepository;
	
	@Override
	public Tests_Master saveTests_Master(Tests_Master tests_Master) {
		// TODO Auto-generated method stub
		return tests_MasterRepository.save(tests_Master);
	}

	@Override
	public List<Tests_Master> getAllTests_Master() {
		// TODO Auto-generated method stub
		return tests_MasterRepository.findAll();
	}

	@Override
	public Tests_Master getTests_MasterById(int id) {
		// TODO Auto-generated method stub
		return tests_MasterRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteTests_MasterId(int id) {
		// TODO Auto-generated method stub
		tests_MasterRepository.deleteById(id);
	}

}
