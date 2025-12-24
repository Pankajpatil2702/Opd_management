package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Bill;
import com.opd_management.exception.DataBaseException;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.BillRepository;
import com.opd_management.services.BillService;

@Service
public class BillIMPL implements BillService {

	@Autowired
	private BillRepository billRepository;
	
	@Override
	public Bill saveBill(Bill bill) {
		try {
			
			return billRepository.save(bill);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failes to save bill due to database error");
		}
		
	}

	@Override
	public List<Bill> getAllBill() {

		try {
			return billRepository.findAll();
			
		}
		catch(Exception e) {
			
			throw new DataBaseException("Falied to find all bill due to database error");
		}
	}
	

	@Override
	public Bill getBillById(int id) {
		
		
		return billRepository.findById(id).orElseThrow(() -> new 
				ResourseNotFoundException("bill not found with id: " + id));
	}

	@Override
	public void deleteBillId(int id) {
		try {
			
			billRepository.deleteById(id);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to delete bill due to database error");
		}
		
		
		
	}

}
