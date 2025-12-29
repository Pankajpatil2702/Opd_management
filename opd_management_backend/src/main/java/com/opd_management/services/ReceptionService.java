package com.opd_management.services;

import java.util.List;
import com.opd_management.entities.Reception;

public interface ReceptionService {
	
	// save Data from table
	Reception saveReception(Reception reception);
	
	// to get all data
	List<Reception> getAllReceptions();
	
	// get data from table using id
	Reception getReceptionById(int id);
	
	// delete specific id from table using id
	void deleteReceptionById(int id);

}
