package com.twd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twd.model.Plan;

@Repository
public interface PlanDAO extends JpaRepository<Plan, Integer>{
	List<Plan> findPlanByCity(String city);

}
