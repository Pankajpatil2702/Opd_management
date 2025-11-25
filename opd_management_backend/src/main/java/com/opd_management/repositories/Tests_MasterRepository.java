package com.opd_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.Tests_Master;

@Repository
public interface Tests_MasterRepository extends JpaRepository<Tests_Master, Integer> {

}
