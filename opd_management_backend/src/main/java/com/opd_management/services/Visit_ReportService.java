package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Visit_Report;

public interface Visit_ReportService {
	
	Visit_Report saveVisit_Report(Visit_Report visit_Report);
	
	List<Visit_Report> getAllVisit_Report();
	
	Visit_Report getVisit_ReportById(int id);
	
	void deleteVisit_ReportId(int id);

}
