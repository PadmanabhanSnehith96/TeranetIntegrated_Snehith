package com.twd.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "signup")
public class SignUp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@NotEmpty(message = "username cannot be empty")
	private String userName;

	@NotEmpty(message = "Mobile number cannot be empty")
	@Pattern(regexp = "\\d{10}", message = "mobile number can be only 10 digits")
	private String mobileNumber;

	@NotEmpty(message = "Email ID cannot be null")
	@Email(message = "Invalid Email Id")
	private String emailId;

	@NotEmpty(message = "password cannot be empty")
	@Size(min = 8, message = "Password must have a minimum of 8 characters in length")
	private String password;

	@NotEmpty(message = "password cannot be empty")
	@Size(min = 8, message = "Password must have a minimum of 8 characters in length")
	private String confirmPassword;

	@Enumerated(EnumType.STRING)
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "userPlan")
	private Plan userPlan;

	@JsonIgnore
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Billing bill;
	
	public SignUp() {
		super();
	}
	
	public SignUp(long userId, @NotEmpty(message = "username cannot be empty") String userName,
			@NotEmpty(message = "Mobile number cannot be empty") @Pattern(regexp = "\\d{10}", message = "mobile number can be only 10 digits") String mobileNumber,
			@NotEmpty(message = "Email ID cannot be null") @Email(message = "Invalid Email Id") String emailId,
			@NotEmpty(message = "password cannot be empty") @Size(min = 8, message = "Password must have a minimum of 8 characters in length") String password,
			@NotEmpty(message = "password cannot be empty") @Size(min = 8, message = "Password must have a minimum of 8 characters in length") String confirmPassword,
			City city,  Billing bill) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.city = city;
		
		this.bill = bill;
	}
	
	public Billing getBill() {
		return bill;
	}

	public void setBill(Billing bill) {
		this.bill = bill;
	}

	public Plan getUserPlan() {
		return userPlan;
	}

	public void setUserPlan(Plan userPlan) {
		this.userPlan = userPlan;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	
}
