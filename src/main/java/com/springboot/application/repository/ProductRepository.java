package com.springboot.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.application.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByNameContaining(String name);
	
	//Set<Product> save(Set<Product> set);
}
