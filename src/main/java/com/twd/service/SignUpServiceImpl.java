package com.twd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twd.dao.SignUpRepository;
import com.twd.model.SignUp;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private SignUpRepository sur;

	@Override
	public boolean existsByEmailId(String emailId) {
		return sur.existsByEmailId(emailId);
	}

	@Override
	public SignUp findByEmailId(String emailId) {
		return sur.findByEmailId(emailId);
	}

	@Override
	public boolean checkConfirmPassword(SignUp signup) {
		boolean isValid = false;
		if (signup.getPassword().equals(signup.getConfirmPassword())) {
			isValid = true;
		}
		return isValid;
	}

	@Override
	public SignUp addUser(SignUp signup) {
		return sur.save(signup);
	}
	
}
