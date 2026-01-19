package com.opd_management.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.Reception;

@Repository
public interface ReceptionRepository extends JpaRepository<Reception, Integer> {

	boolean existsByEmail(String email);
	
	Reception findByEmail(String email);
}
