package com.smart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.entity.User;
import com.smart.repository.UserRepository;

@Service
public class UserService {
    
	@Autowired
	private UserRepository userRepository;
	
	//Save User
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	//Get all users
    public List<User> getAllUsers() {
    	return userRepository.findAll();
    }
    
    //Get users by Id
    public User getUsersById(Long id) {
    	return userRepository.findById(id).orElse(null);
    }
    
    
    // Delete Users
    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }
    
	
}
