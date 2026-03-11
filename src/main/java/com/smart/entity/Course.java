package com.smart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "course_name")
	private String courseName;
	
	private String description;
	
	private String duration;
	
	// Constructors
	
	public Course() {
		
	}
	
	public Course(String courseName, String description, String duration) {
		this.courseName = courseName;
		this.description = description;
		this.duration = duration;
		
	}
	
	
	// Getters and Setters
	
	public Long getId() {
		return id;
	}
	
	
	public String getCourseName() {
		return courseName;
	}
	
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getDescription() {
		return description;
	}
	
	
	public void setDescription (String description) {
		this.description = description;
	}
	
	public String getDuration() {
		return duration;
	}
	
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	
	
}
