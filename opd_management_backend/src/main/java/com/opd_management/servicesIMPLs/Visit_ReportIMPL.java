package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Visit_Report;
import com.opd_management.exception.DataBaseException;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.Visit_ReportRepository;
import com.opd_management.services.Visit_ReportService;
@Service
public class Visit_ReportIMPL implements Visit_ReportService {

	@Autowired
	private Visit_ReportRepository visit_ReportRepository;
	
	@Override
	public Visit_Report saveVisit_Report(Visit_Report visit_Report) {
		
		try {
			
			return visit_ReportRepository.save(visit_Report);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to save visit report due to database error");
		}
	}

	@Override
	public List<Visit_Report> getAllVisit_Report() {
		
		try {
			
			return visit_ReportRepository.findAll();
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to find visit report due to database error");
		}
	}

	@Override
	public Visit_Report getVisit_ReportById(int id) {
		
		return visit_ReportRepository.findById(id).orElseThrow(() -> new 
				ResourseNotFoundException("visit report not found with id: " + id));
	}

	@Override
	public void deleteVisit_ReportId(int id) {
		
		try {
			
			visit_ReportRepository.deleteById(id);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to delete visit report due to database error");
		}
	}

	@Override
	public List<Visit_Report> getVisitReportById(Long visitid) {
		// TODO Auto-generated method stub
		try {
			
			return visit_ReportRepository.findByVisitid_Id(visitid);
			
		} catch (Exception e) {
			
			throw new ResourseNotFoundException("Report not found for visit id " + visitid);
		}
	}

	
	
}
