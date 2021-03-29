package com.springboot.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String email;
private String username;
private String password;
private String role;
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Long getId() {
	return id;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}

public User(String email, String username, String password, String role) {
	super();
	this.email = email;
	this.username = username;
	this.password = password;
	this.role = role;
}



}
