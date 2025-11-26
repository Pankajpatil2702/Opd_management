package com.opd_management.services;

import java.util.List;

import com.opd_management.entities.Bill;

public interface BillService {
	
	Bill saveBill(Bill bill);
	
	List<Bill> getAllBill();
	
	Bill getBillById(int id);
	
	void deleteBillId(int id);

}
