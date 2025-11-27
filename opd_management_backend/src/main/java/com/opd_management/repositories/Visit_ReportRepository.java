package com.opd_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.Visit_Report;

@Repository
public interface Visit_ReportRepository extends JpaRepository<Visit_Report, Integer> {

}
