package com.twd.service;

import com.twd.model.SignUp;

public interface SignUpService {

	boolean existsByEmailId(String emailId);

	SignUp findByEmailId(String emailId);

	boolean checkConfirmPassword(SignUp signup);

	SignUp addUser(SignUp signup);
}
