package com.smart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.entity.Course;
import com.smart.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping 
	public Course saveCourse(@RequestBody Course course) {
		return courseService.saveCourse(course);
	}
     
	@GetMapping
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	@GetMapping("/{id}")
	public Course getCourse(@PathVariable("id") Long id) {
		
		return courseService.getCourseById(id);
	}
	
	 
	
}
