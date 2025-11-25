package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Tests_Master;

public interface Tests_MasterService {

	Tests_Master saveTests_Master(Tests_Master tests_Master);
	
	List<Tests_Master> getAllTests_Master();
	
	Tests_Master getTests_MasterById(int id);
	
	void deleteTests_MasterId(int id);
}
