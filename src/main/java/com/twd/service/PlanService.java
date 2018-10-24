package com.twd.service;

import java.util.List;

import com.twd.model.Plan;

public interface PlanService {
	Plan addPlan(Plan plan);

	Plan updatePlan(Plan plan);

	boolean deletePlan(int planId);

	Plan getById(int planId);

	List<Plan> getAllPlans();
	
	List<Plan> findPlanByCity(String city);
	
}
