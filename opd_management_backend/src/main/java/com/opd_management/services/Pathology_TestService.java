package com.opd_management.services;

import java.util.List;
import com.opd_management.entities.Pathology_Test;

public interface Pathology_TestService {

	// to save/insert data from pathology_test
	Pathology_Test savePathology_Test(Pathology_Test pathology_Test);
	
	// to get all data from pathology_test
	List<Pathology_Test> getAllPathology_Test();
	
	// to get specific data using id from pathology_test
	Pathology_Test getPathologyById(int id);
	
	// to delete specific data using id from pathology test
	void deletePathologyId(int id);
}
