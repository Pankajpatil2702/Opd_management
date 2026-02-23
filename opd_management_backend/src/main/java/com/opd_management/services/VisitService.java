package com.opd_management.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.opd_management.entities.Visit;

public interface VisitService {
	
	// save/insert data into visit
	Visit saveVisit(Visit visit);
	
	// get all data from visit
	List<Visit> getAllVisit();
	
	// get specific data using id from visit
	Visit getVisitByID(int id);
	
	// delete specific data using id from visit
	void deleteVisiteId(int id);

	// get visit by date wise
	List<Visit> findAllByVisit_date(LocalDate visit_date);
}
