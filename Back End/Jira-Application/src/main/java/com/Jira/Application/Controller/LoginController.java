package com.Jira.Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jira.Application.Entity.LogIn;
import com.Jira.Application.Service.LoginService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/login")
public class LoginController {
    
	@Autowired
	private LoginService loginService;
	
	@PostMapping
	public LogIn saveUser(@RequestBody LogIn logIn) {
		return loginService.saveUser(logIn);
	}
}
