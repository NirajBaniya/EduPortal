package com.smart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entity.Application;
import com.smart.entity.Course;
import com.smart.entity.User;

public interface ApplicationRepository  extends JpaRepository<Application, Long>{

	// because condition is user cannot choose same course twice
	boolean existsByUserAndCourse(User user, Course course);
	
	List<Application> findByUserId(Long userId);
	
	
	
	
	
	
	
	
}
