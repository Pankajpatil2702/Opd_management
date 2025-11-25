package com.opd_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opd_management.entities.Referral_Center;

@Repository
public interface Referral_CenterRepository extends JpaRepository<Referral_Center, Integer> {

}
