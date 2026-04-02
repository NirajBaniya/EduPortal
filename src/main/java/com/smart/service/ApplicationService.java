package com.smart.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.entity.Application;
import com.smart.entity.ApplicationStatus;
import com.smart.entity.Course;
import com.smart.entity.User;
import com.smart.repository.ApplicationRepository;
import com.smart.repository.CourseRepository;
import com.smart.repository.UserRepository;

@Service
public class ApplicationService {

	 @Autowired
	 private ApplicationRepository applicationRepository;
	 
	 @Autowired
	 private UserRepository userRepository;
	 
	 @Autowired
	 private CourseRepository courseRepository;
	 
	 
	 
	 
	 
	 public Application apply(Application application) {
		 
		 //   Validation 
		 
		 if(application.getUser() == null || application.getCourse() == null) {
			 throw new RuntimeException("User and course must be provided");
		 }
		 
		 // Gpa validation
		 if(application.getGpa() == null || application.getGpa() < 0 || application.getGpa() > 4 ) {
			 throw new RuntimeException("GPA must be between 0 to 4");
		 }
		 
		 
		 
		 // Get IDs from request
		 Long userId = application.getUser().getId();
		 Long courseId = application.getCourse().getId();
		 
		 
		 //  Fetching full objects from database
		 User user = userRepository.findById(userId)
				 .orElseThrow(() -> new RuntimeException("User not found"));
		 
		 
		 Course course = courseRepository.findById(courseId)
				 .orElseThrow(() -> new RuntimeException("Course not found"));
		 
		 
		 
		 // It Check duplicate application
		 
		 
		    boolean alreadyApplied = 
		    		applicationRepository.existsByUserAndCourse(user, course);
		   
		  
		    if(alreadyApplied) {
		    	throw new RuntimeException("You have already applied to this course");
		    }
	
		    
		    // Set correct objects
		    
		    application.setUser(user);
		    application.setCourse(course);
		    
		    
		    // Default values 
		    
		    application.setStatus(ApplicationStatus.PENDING);
		    application.setAppliedDate(LocalDate.now());
		 
		 return applicationRepository.save(application);
	 }
	 
	 
	 
	 
	 
	 public List<Application> getAllApplication(){
		 return applicationRepository.findAll();
	 }
	 
	 
	 public Application getApplicationById(Long id) {
		 return applicationRepository.findById(id)
				 .orElseThrow(() -> new RuntimeException("Application not found"));
	 }
	 
	 
	 
	 
	 
	 // if user want to see their application 
	 public List<Application> getApplicationsByUser(Long userId) {
		 return applicationRepository.findByUserId(userId);
	 }
	 
	 
	 
	 // Admin must able to ACCEPT, REJECT AND PENDING the applications
	 
	 public Application updateStatus(Long id, ApplicationStatus status) {
		    
		 Application app = applicationRepository.findById(id)
				 .orElseThrow(() -> new RuntimeException("Application not found"));
		 
		 app.setStatus(status);
		 
		
		 return applicationRepository.save(app);
				 
	 }
	 
	 
	 
	 
	 
	 
	 public void deleteApplication(Long id) {
		 
		 if(!applicationRepository.existsById(id)) {
			  throw new RuntimeException("Application not found");
		 }
		 
		 applicationRepository.deleteById(id);
	 }
	 
	 
}
