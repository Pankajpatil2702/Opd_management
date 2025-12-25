package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Diagnostic;
import com.opd_management.exception.DataBaseException;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.DiagnosticRepository;
import com.opd_management.services.DiagnosticService;

@Service
public class DiagnosticIMPL implements DiagnosticService {

	@Autowired
	private DiagnosticRepository diagnosticRepository;
	
	@Override
	public Diagnostic saveDiagnostic(Diagnostic diagnostic) {
		try {
			
			return diagnosticRepository.save(diagnostic);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to save diagnostic due to database error");
		}
		
	}

	@Override
	public List<Diagnostic> getAllDiagnostic() {
		try {
			return diagnosticRepository.findAll();
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to find diagnostic due to database error");
		}
	}

	@Override
	public Diagnostic getDiagnosticById(int id) {
		// TODO Auto-generated method stub
		return diagnosticRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("diagnostic not found with id:" + id));
	}

	@Override
	public void deleteDiagnostic(int id) {
		try {
			diagnosticRepository.deleteById(id);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to delete diagnostic due to database error");
		}
	}

}
