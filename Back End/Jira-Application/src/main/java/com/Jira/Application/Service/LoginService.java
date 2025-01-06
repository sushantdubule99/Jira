package com.Jira.Application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jira.Application.Entity.LogIn;
import com.Jira.Application.Repository.LoginRepository;

@Service
public class LoginService {
    
	@Autowired
	private LoginRepository loginRepository;
	
	public LogIn saveUser(LogIn logIn) {
		return loginRepository.save(logIn);
	}
}
