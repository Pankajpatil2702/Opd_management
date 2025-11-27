package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Visit_Report;
import com.opd_management.repositories.Visit_ReportRepository;
import com.opd_management.services.Visit_ReportService;
@Service
public class Visit_ReportIMPL implements Visit_ReportService {

	@Autowired
	private Visit_ReportRepository visit_ReportRepository;
	
	@Override
	public Visit_Report saveVisit_Report(Visit_Report visit_Report) {
		// TODO Auto-generated method stub
		return visit_ReportRepository.save(visit_Report);
	}

	@Override
	public List<Visit_Report> getAllVisit_Report() {
		// TODO Auto-generated method stub
		return visit_ReportRepository.findAll();
	}

	@Override
	public Visit_Report getVisit_ReportById(int id) {
		// TODO Auto-generated method stub
		return visit_ReportRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteVisit_ReportId(int id) {
		// TODO Auto-generated method stub
		visit_ReportRepository.deleteById(id);
	}

}
