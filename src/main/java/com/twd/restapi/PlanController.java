package com.twd.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twd.model.Plan;
import com.twd.service.PlanService;

@RestController
@CrossOrigin
@RequestMapping("/plans")
public class PlanController {
	
	@Autowired
	private PlanService service;
	
	@GetMapping
	public ResponseEntity<List<Plan>> getAllPlans() {
		return new ResponseEntity<>(service.getAllPlans(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Plan> getContactById(@PathVariable("id") int planId) {
		ResponseEntity<Plan> resp;
		Plan c = service.getById(planId);
		if (c == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(c, HttpStatus.OK);
		return resp;
	}

	@PostMapping
	public ResponseEntity<Plan> addPlan(@RequestBody Plan plan) {
		ResponseEntity<Plan> resp = null;

		if (resp == null) {
			Plan c = service.addPlan(plan);
			if (c == null)
				resp = new ResponseEntity<Plan>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Plan>(c, HttpStatus.OK);
		}
		return resp;
	}

	@PutMapping
	public ResponseEntity<Plan> updatePlan(@RequestBody Plan plan) {
		ResponseEntity<Plan> resp = null;

		Plan c = service.getById(plan.getPlanId());
		
		if (resp == null) {
			c = service.updatePlan(plan);
			if (c == null)
				resp = new ResponseEntity<Plan>(HttpStatus.BAD_REQUEST);
			else
				resp = new ResponseEntity<Plan>(c, HttpStatus.OK);
		}
		return resp;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlan(@PathVariable("id") int planId) {
		ResponseEntity<Void> resp = null;

		if (service.deletePlan(planId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return resp;
	}
	
		
	
	
}
