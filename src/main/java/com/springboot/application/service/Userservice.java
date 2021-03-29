package com.springboot.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.application.model.User;
import com.springboot.application.repository.Userrepository;


@Service
public class Userservice {

	
	@Autowired private Userrepository repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}

	public User fetchUserByEmailId(String tempEmailId) {
		// TODO Auto-generated method stub
		return repo.findByEmail(tempEmailId);
	}

	public User fetchUserByEmailIdAndPassword(String tempEmailId, String tempPass) {
		// TODO Auto-generated method stub
		return repo.findByemailAndPassword(tempEmailId, tempPass);
	}
}
