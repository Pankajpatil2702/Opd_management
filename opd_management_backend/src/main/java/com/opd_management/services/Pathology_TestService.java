package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Pathology_Test;

public interface Pathology_TestService {

	Pathology_Test savePathology_Test(Pathology_Test pathology_Test);
	
	List<Pathology_Test> getAllPathology_Test();
	
	Pathology_Test getPathologyById(int id);
	
	void deletePathologyId(int id);
}
