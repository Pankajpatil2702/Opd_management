package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Diagnostic;
import com.opd_management.repositories.DiagnosticRepository;
import com.opd_management.services.DiagnosticService;

@Service
public class DiagnosticIMPL implements DiagnosticService {

	@Autowired
	private DiagnosticRepository diagnosticRepository;
	
	@Override
	public Diagnostic saveDiagnostic(Diagnostic diagnostic) {
		// TODO Auto-generated method stub
		return diagnosticRepository.save(diagnostic);
	}

	@Override
	public List<Diagnostic> getAllDiagnostic() {
		// TODO Auto-generated method stub
		return diagnosticRepository.findAll();
	}

	@Override
	public Diagnostic getDiagnosticById(int id) {
		// TODO Auto-generated method stub
		return diagnosticRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteDiagnostic(int id) {
		// TODO Auto-generated method stub
		diagnosticRepository.deleteById(id);
	}

}
