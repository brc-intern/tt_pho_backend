package com.springboot.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.application.model.User;


public interface Userrepository extends JpaRepository<User, Long>{

	public User findByEmail(String email);
	public User findByemailAndPassword(String email, String password);
}
