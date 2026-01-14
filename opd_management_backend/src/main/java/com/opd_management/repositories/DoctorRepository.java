package com.opd_management.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	boolean existsByemail(String email);   // to find already email exist..
	
	Optional<Doctor> findByEmail(String email);      
	//Boolean existsByMobileNo(String mobileNo);  // to show already mobile no exist.

}
