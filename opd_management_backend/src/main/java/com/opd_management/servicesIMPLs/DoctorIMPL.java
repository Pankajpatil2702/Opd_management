package com.opd_management.servicesIMPLs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opd_management.entities.Doctor;
import com.opd_management.exception.DataBaseException;
import com.opd_management.exception.DuplicateResourceException;
import com.opd_management.exception.ResourseNotFoundException;
import com.opd_management.repositories.DoctorRepository;
import com.opd_management.services.DoctorService;

@Service
public class DoctorIMPL implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public Doctor saveDoctor(Doctor doctor) {
	try {
		
		try {
			doctorRepository.existsByemail(doctor.getEmail());
			
			try {
				doctorRepository.existsByMobileNo(doctor.getMobileNo());
			}
			catch(Exception e) {
				throw new DuplicateResourceException("doctor with monileNo" + doctor.getMobileNo() + "already exist");
			}
		} 
		catch (Exception e) {
			throw new DuplicateResourceException("doctor with email " + doctor.getEmail() + " already exists");
		}
		return doctorRepository.save(doctor);
	}
		catch (Exception e) {
			throw new DataBaseException("Failed to save teacher due to database error");
		}
		
	}

	
	@Override
	public List<Doctor> getAllDoctor() {
		
		try {
			
			return doctorRepository.findAll();
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to find doctor due to database error");
		}
	}

	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException(" Doctor not Found with id: "+id));
	}

	@Override
	public void deleteDoctorId(int id) {
		
		try {
			
			doctorRepository.deleteById(id);
		}
		catch(Exception e) {
			
			throw new DataBaseException("Failed to delete due to database error");
		}
	}

}
