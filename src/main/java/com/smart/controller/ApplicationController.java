package com.smart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.entity.Application;
import com.smart.service.ApplicationService;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    
	@Autowired
	private ApplicationService applicationService;
	
	@PostMapping
	public Application apply(@RequestBody Application application) {
		return applicationService.apply(application);
	}
	
	
	@GetMapping 
	public List<Application> getAllApplications() {
		return applicationService.getAllApplication();
	}
	
	
}
