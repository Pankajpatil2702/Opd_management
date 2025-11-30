package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Bill;

public interface BillService {
	
	// to save or insert data into table
	Bill saveBill(Bill bill);
	
	// get all data from table
	List<Bill> getAllBill();
	
	// get data using id
	Bill getBillById(int id);
	
	// delete specific data using id
	void deleteBillId(int id);

}
