package com.twd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twd.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

	boolean existsByEmailId(String emailId);

	
}
