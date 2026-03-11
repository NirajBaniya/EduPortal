package com.smart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.entity.User;
import com.smart.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
		
	}
	
	@GetMapping
	public List<User> getAllUsers() {
		
		return userService.getAllUsers();
		
	}
	
	
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return userService.getUsersById(id);
	}
      
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
	}
	
	
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		
		User existingUser = userService.getUsersById(id);
		
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setAddress(user.getAddress());
		
		return userService.saveUser(existingUser);
	}
	   
}
