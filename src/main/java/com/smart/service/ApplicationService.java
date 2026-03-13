package com.smart.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.entity.Application;
import com.smart.entity.ApplicationStatus;
import com.smart.repository.ApplicationRepository;

@Service
public class ApplicationService {

	 @Autowired
	 private ApplicationRepository applicationRepository;
	 
	 
	 public Application apply(Application application) {
		 
		    boolean alreadyApplied = 
		    		applicationRepository.existsByUserAndCourse(
		    		           application.getUser(),
		    		           application.getCourse()
		    				
		    				);
		  
		    if(alreadyApplied) {
		    	throw new RuntimeException("You have already applied to this course");
		    }
		    
		    application.setStatus(ApplicationStatus.PENDING);
		    application.setAppliedDate(LocalDate.now());
		 
		 return applicationRepository.save(application);
	 }
	 
	 
	 
	 
	 
	 public List<Application> getAllApplication(){
		 return applicationRepository.findAll();
	 }
	 
	 
	 public Application getApplicationById(Long id) {
		 return applicationRepository.findById(id).orElse(null);
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
		 applicationRepository.deleteById(id);
	 }
	 
	 
}
