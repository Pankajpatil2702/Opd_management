package com.opd_management.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opd_management.entities.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
	
	List<Visit> findByVisitDate(LocalDate visitDate);
 // 

}
