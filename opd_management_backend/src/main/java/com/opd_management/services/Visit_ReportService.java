package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Visit_Report;

public interface Visit_ReportService {
	
	// save/insert data into visit_report
	Visit_Report saveVisit_Report(Visit_Report visit_Report);
	
	// get all data from visit_report
	List<Visit_Report> getAllVisit_Report();
	
	// get specific data using id from visit_report
	Visit_Report getVisit_ReportById(int id);
	
	// delete specific data using id from visit_report
	void deleteVisit_ReportId(int id);

}
