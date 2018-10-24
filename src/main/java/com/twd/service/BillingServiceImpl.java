package com.twd.service;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twd.dao.BillingRepository;
import com.twd.model.Billing;


@Service
public class BillingServiceImpl implements BillingService {
	
	@Autowired
	BillingRepository billRepo;
	
	@Override
	public Billing getBillById(long billId) {
		Billing bill = null;
		
		Optional<Billing> optBill = billRepo.findById(billId);
		
		if( optBill.isPresent()) {
			bill = optBill.get();
		}
		return bill;
	}

	@Override
	public Billing addBill(Billing bill) {
		
		return billRepo.save(bill);
	}

	@Override
	public Double CalculateBillAmount(Billing bill) {
		double b;
		
		LocalDate currentDate = LocalDate.now();
		
		if(currentDate.isAfter((ChronoLocalDate)bill.getExpiryDate())) {
			
	
			long extraDays = ChronoUnit.DAYS.between(bill.getExpiryDate().plusDays(5), LocalDate.now());
			b = bill.getUser().getUserPlan().getPrice() + extraDays*10;
		}
		else 
			b = bill.getUser().getUserPlan().getPrice();
		return b;
		
		
	}
	
	@Override
	public int generateCurrentUsage(Billing bill) {
		int usage = (int)(Math.random()*(bill.getUser().getUserPlan().getMaxUsage()-(bill.getUser().getUserPlan().getMaxUsage()*0.2))+(bill.getUser().getUserPlan().getMaxUsage()*0.8));
		System.out.println("USer "+bill.getUser().getUserName());
		return usage;
	}

	@Override
	public LocalDate setActivationDate(Billing bill) {
		int day = (int)(Math.random()*(28+1))+1;
		int month = (int)Math.floor((Math.random()*(LocalDate.now().getMonthValue()))+1);
		return LocalDate.of(2018, month, day);
	}

	@Override
	public LocalDate setExpiryDate(Billing bill) {
		LocalDate expiry = bill.getActivationDate().plusDays(bill.getUser().getUserPlan().getValidity());
		return expiry;
	}

	@Override
	public Billing setDeatils(Billing bill) {
		//bill.setCurrentUsage(generateCurrentUsage(bill));
	
		bill.setActivationDate(setActivationDate(bill));
		
		bill.setExpiryDate(setExpiryDate(bill)); 
		
		bill.setBillAmount(CalculateBillAmount(bill));
		return bill;
	}

}
