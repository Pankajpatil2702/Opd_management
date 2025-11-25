package com.opd_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opd_management.entities.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

}
