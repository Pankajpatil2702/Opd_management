package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Bill;
import com.opd_management.repositories.BillRepository;
import com.opd_management.services.BillService;

@Service
public class BillIMPL implements BillService {

	@Autowired
	private BillRepository billRepository;
	
	@Override
	public Bill saveBill(Bill bill) {
		// TODO Auto-generated method stub
		return billRepository.save(bill);
	}

	@Override
	public List<Bill> getAllBill() {
		// TODO Auto-generated method stub
		return billRepository.findAll();
	}

	@Override
	public Bill getBillById(int id) {
		// TODO Auto-generated method stub
		return billRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteBillId(int id) {
		// TODO Auto-generated method stub
		billRepository.deleteById(id);
	}

}
