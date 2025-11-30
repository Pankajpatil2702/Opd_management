package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Tests_Master;

public interface Tests_MasterService {

	// save/insert data into tests_master
	Tests_Master saveTests_Master(Tests_Master tests_Master);
	
	// get all data from tests_master
	List<Tests_Master> getAllTests_Master();
	
	// get specific data using id from tests_master
	Tests_Master getTests_MasterById(int id);
	
	// delete specific data using id from tests_master
	void deleteTests_MasterId(int id);
}
