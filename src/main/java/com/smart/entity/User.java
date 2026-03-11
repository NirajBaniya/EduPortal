package com.smart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
      
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)	
	    private Long id;
		
		private String name;
		
		@Column(unique = true)
		private String email;
		
		
		private String password;
		
		@Enumerated(EnumType.STRING)
		private Role role;
		
		private String address;
		
		private String profileImage;
		
		
		//Constructor
		public User() {
			
		}
			
			public User(String name, String email, String password, Role role, String address, String profileImage) {
				this.name = name;
				this.email = email;
				this.password = password;
				this.role = role;
				this.address = address; 
				this.profileImage = profileImage;
				
			}
		
			//Getters and Setters
			
			public Long getId() {
				return id;
			}
			
			
			public String getName() {
				return name;
			}
			
			public void setName(String name) {
				this.name = name;
			}
		
		   
			public String getEmail() {
				return email;
			}
			
			public void setEmail(String email) {
				this.email = email;
			}
			
			public String getPassword() {
				return password;
			}
			
			public void setPassword(String password) {
				this.password = password;
			}
			
			public Role getRole() {
				return role;
			}
			
			public void setRole(Role role) {
				this.role = role;
			}
		
			public String getAddress() {
				return address;
			}
			
			public void setAddress(String address) {
				this.address = address;
			}
		
			public String getProfileImage() {
				return profileImage;
			}
			
			public void setProfileImage(String profileImage) {
				this.profileImage = profileImage;
			}
	
	
}
