package com.smart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.entity.Application;
import com.smart.repository.ApplicationRepository;

@Service
public class ApplicationService {

	 @Autowired
	 private ApplicationRepository applicationRepository;
	 
	 
	 public Application apply(Application application) {
		 return applicationRepository.save(application);
	 }
	 
	 
	 public List<Application> getAllApplication(){
		 return applicationRepository.findAll();
	 }
	 
	 
	 public Application getApplicationById(Long id) {
		 return applicationRepository.findById(id).orElse(null);
	 }
	 
	 public void deleteApplication(Long id) {
		 applicationRepository.deleteById(id);
	 }
	 
	 
}
