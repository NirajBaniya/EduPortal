package com.smart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entity.User;

public interface UserRepository extends JpaRepository<User ,  Long> {
     
	// we will use login for this email + password is required.
	Optional<User> findByEmail(String Email);
	
}
