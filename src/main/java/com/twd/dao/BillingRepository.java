package com.twd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twd.model.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
	
}
