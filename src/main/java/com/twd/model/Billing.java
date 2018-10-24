package com.twd.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="bills")
public class Billing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long billId;
	
	//private int currentUsage;
	
	private double billAmount;
	
	
	private LocalDate ActivationDate;
	
	private LocalDate ExpiryDate;
	
	@OneToOne
	@JoinColumn(name="user")
	private SignUp user;
	
	public Billing(long billId, double billAmount, LocalDate activationDate, LocalDate expiryDate) {
		super();
		this.billId = billId;
		this.billAmount = billAmount;
		ActivationDate = activationDate;
		ExpiryDate = expiryDate;
	}
	public Billing() {
		super();
	}
	public SignUp getUser() {
		return user;
	}
	public void setUser(SignUp user) {
		this.user = user;
	}

	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public LocalDate getActivationDate() {
		return ActivationDate;
	}

	public void setActivationDate(LocalDate activationDate) {
		ActivationDate = activationDate;
	}

	public LocalDate getExpiryDate() {
		return ExpiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		ExpiryDate = expiryDate;
	}

	
	
}