package com.twd.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twd.model.Billing;
import com.twd.service.BillingServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/billing")
public class BillingApi {
	
	@Autowired
	BillingServiceImpl service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Billing> getBillById(@PathVariable("id") long billId) {
		ResponseEntity<Billing> resp = null;
		
		Billing bill = service.getBillById(billId);
		System.out.println(bill.getUser());
		
		if(bill == null) {
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			resp = new ResponseEntity<>(bill, HttpStatus.OK);
		}
		
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<Billing> addBill(@RequestBody Billing bill) {
		ResponseEntity<Billing> resp = null;
		Billing billing = new Billing();
		Billing newbill=new Billing();
	
		if(resp == null) {

			billing = service.addBill(bill);
			
			//System.out.println("2222222222222"+billing.getUser().getUserName()+"22222222"+billing.getUser().getUserPlan());
			
			newbill=service.setDeatils(billing);
			
		
			if(billing == null ) {
				resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}else {
				resp = new ResponseEntity<>(newbill, HttpStatus.OK);
			}
		}
		
		return resp;
	}
}
