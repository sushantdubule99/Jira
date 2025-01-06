package com.Jira.Application.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jira.Application.Entity.User;
import com.Jira.Application.Repository.TicketRepository;
import com.Jira.Application.Repository.UserRepository;

@Service
public class UserService {
  
	@Autowired
	private UserRepository userRepository;
	
	public List<User>getAllUsers(){
		return userRepository.findAll();
	}
	 
	public User createUser(User user) {
		return userRepository.save(user);
	} 
	
	public void deleteUserById(long userId)  {
		Optional <User> userOptional = userRepository.findById(userId);
		if(userOptional.isPresent()) {
			userRepository.deleteById(userId);
		}else {
			throw new  IllegalArgumentException("User not found with id"+userId);
		}
	}
}
