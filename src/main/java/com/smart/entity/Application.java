package com.smart.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "application")
public class Application {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 
	 // Many applications can be belong to one user 
	 @ManyToOne
	 @JsonIgnore
	 @JoinColumn(name = "user_id")
	 private User user;
	 
	 // Many applications can be belong to one course
	 @ManyToOne
	 @JoinColumn(name = "course_id")
	 private Course course;
	 
	 
	 private Double gpa;

	 private String documentPath;
	 
	 @Enumerated(EnumType.STRING)
	 private ApplicationStatus status;
	 
	 private String adminComment;
	 
	 
	 private LocalDate appliedDate;
      
	 
	 // Default Constructor (Required By JPA)
	 public Application() {
		 
	 }
	 
	 
	 // Parameterized Constructor
	 public Application(User user, Course course, Double gpa, String documentPath, 
			           ApplicationStatus status, String adminComment, LocalDate appliedDate) {
		 
		 this.user = user;
		 this.course = course;
		 this.gpa = gpa;
		 this.documentPath = documentPath;
		 this.status = status;
		 this.adminComment = adminComment;
		 this.appliedDate = appliedDate;
		 
		 
	 }
	 
	 // Getters and Setters
	 
	 public Long getId() {
		 return id;
	 }
	 
	 
	 public User getUser() {
		 return user;
	 }
	 
	 public void setUser(User user) {
		 	this.user = user;
	 }
	 
	 public Course getCourse() {
		 return course;
	 }
	 
	 public void setCourse(Course course) {
		 this.course = course;
	 }
	 
	 
	 public Double getGpa() {
		 return gpa;
	 }
	 
	 public void setGpa(Double gpa) {
		 this.gpa = gpa;
	 }
	 
	 public String getDocumentPath() {
		 return documentPath;
	 }
	 
	 public void setDocumentPath(String documentPath) {
		 this.documentPath = documentPath;
	 }
	 
	 public ApplicationStatus getStatus() {
		 return status;
	 }
	 
	 public void setStatus(ApplicationStatus status) {
		 this.status = status;
	 }
	 
	 public String getAdminComment() {
		 return adminComment;
	 }
	 
	 public void setAdminComment(String adminComment) {
		 this.adminComment = adminComment;
	 }
	 
	 
	 public LocalDate getAppliedDate() {
		 return appliedDate;
	 }
	 
	 public void setAppliedDate(LocalDate appliedDate) {
		 this.appliedDate = appliedDate;
	 }
	 
}
