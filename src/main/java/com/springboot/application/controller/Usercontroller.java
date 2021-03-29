package com.springboot.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.application.model.User;
import com.springboot.application.service.Userservice;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Usercontroller {

	@Autowired private Userservice s;
	
	@PostMapping("/registeruser")
	public User RegisterUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmail();
		String name = user.getUsername();
		String pass = user.getPassword();
		if (tempEmailId != null && !"".equals(tempEmailId) && !"".equals(name) && name != null ) {
			User useobj = s.fetchUserByEmailId(tempEmailId);
			if (useobj != null) {
				throw new Exception("user with " + tempEmailId + " already exist");
			}
		}
		User userObj = null;
		if(tempEmailId != null && !"".equals(tempEmailId) && !"".equals(name) && name != null ) {
			
			userObj = s.saveUser(new User(user.getEmail(), user.getUsername(), user.getPassword(), "user"));
			
		}else {
			throw new Exception("user with " + tempEmailId + " alreadfergfrgrg6"); 
		}
		return userObj;
	}
	
	@PostMapping("/registeradmin")
	public User RegisterAdmin(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmail();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			User useobj = s.fetchUserByEmailId(tempEmailId);
			if (useobj != null) {
				throw new Exception("user with " + tempEmailId + " already exist");
			}
		}
		User userObj = null;
		userObj = s.saveUser(new User(user.getEmail(), user.getUsername(), user.getPassword(), "admin"));
		return userObj;
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmail();
		String tempPass = user.getPassword();
		User userObj = null;
		if (tempEmailId != null && tempPass != null) {
			userObj = s.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}	
		if (userObj == null) {
			throw new Exception("Bad credentials");
		}
		return userObj;
	}
}
