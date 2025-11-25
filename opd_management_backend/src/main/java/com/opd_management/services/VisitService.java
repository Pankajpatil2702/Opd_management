package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Visit;

public interface VisitService {
	
	Visit saveVisit(Visit visit);
	
	List<Visit> getAllVisit();
	
	Visit getVisitByID(int id);
	
	void deleteVisiteId(int id);

}
