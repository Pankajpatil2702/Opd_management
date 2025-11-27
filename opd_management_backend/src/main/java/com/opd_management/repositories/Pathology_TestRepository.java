package com.opd_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.Pathology_Test;

@Repository
public interface Pathology_TestRepository extends JpaRepository<Pathology_Test, Integer> {

}
