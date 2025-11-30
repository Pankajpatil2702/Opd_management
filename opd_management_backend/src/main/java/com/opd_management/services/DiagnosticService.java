package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Diagnostic;

public interface DiagnosticService {

	// to save/insert data into diagnostic
	Diagnostic saveDiagnostic(Diagnostic diagnostic);
	
	// get all data from diagnostic
	List<Diagnostic> getAllDiagnostic();
	
	// to get data using id from diagnostic
	Diagnostic getDiagnosticById(int id);
	
	// to delete specific data using is from diagnostic
	void deleteDiagnostic(int id);
}
