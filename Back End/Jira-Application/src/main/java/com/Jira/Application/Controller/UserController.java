package com.Jira.Application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jira.Application.Entity.User;
import com.Jira.Application.Service.UserService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/user")
public class UserController {
  
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User>getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping
	public User saveUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable long userId){
		try {
			userService.deleteUserById(userId);
			return ResponseEntity.ok("User Deleted Successfully");
		}catch(IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
}
