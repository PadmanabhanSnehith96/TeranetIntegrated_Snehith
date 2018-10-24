package com.twd.service;

import java.time.LocalDate;

import com.twd.model.Billing;

public interface BillingService {
	
	Billing getBillById(long billId);
	
	Billing addBill(Billing bill);
	
	Double CalculateBillAmount(Billing bill);
	
	int generateCurrentUsage(Billing bill);
	
	LocalDate setActivationDate(Billing bill);
	
	LocalDate setExpiryDate(Billing bill);
	
	Billing setDeatils(Billing bill);
}
