package com.twd.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="plans")
public class Plan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int planId;
	
	private String planName;
	private int maxUsage;
	private int speed;
	private int validity;
	private double price;
	private int postSpeed;
	private String city;
	private String usageType;
	
	@JsonIgnore
	@OneToMany(mappedBy="userPlan",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<SignUp> users;
	
	public Plan() {
		super();
	}
	
	public Plan(int planId, String planName, int maxUsage, int speed, int validity, double price, int postSpeed,
			String city, String usageType, List<SignUp> users) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.maxUsage = maxUsage;
		this.speed = speed;
		this.validity = validity;
		this.price = price;
		this.postSpeed = postSpeed;
		this.city = city;
		this.usageType = usageType;
		this.users = users;
	}

	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public int getMaxUsage() {
		return maxUsage;
	}
	public void setMaxUsage(int maxUsage) {
		this.maxUsage = maxUsage;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPostSpeed() {
		return postSpeed;
	}
	public void setPostSpeed(int postSpeed) {
		this.postSpeed = postSpeed;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUsageType() {
		return usageType;
	}
	public void setUsageType(String usageType) {
		this.usageType = usageType;
	}
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}
	public List<SignUp> getUsers() {
		return users;
	}
	public void setUsers(List<SignUp> users) {
		this.users = users;
	}
	
	
	
}
