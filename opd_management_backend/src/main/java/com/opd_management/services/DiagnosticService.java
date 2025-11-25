package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Diagnostic;

public interface DiagnosticService {

	Diagnostic saveDiagnostic(Diagnostic diagnostic);
	
	List<Diagnostic> getAllDiagnostic();
	
	Diagnostic getDiagnosticById(int id);
	
	void deleteDiagnostic(int id);
}
