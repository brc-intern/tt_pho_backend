package com.springboot.application.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.application.model.Product;
import com.springboot.application.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public Product ListProduct(Product product) {
		return productRepository.save(product);
	}
	public Set<Product> save(Set<Product> set){
		return productRepository.save(set);
	}

	public List<Product> findByName(String name) {
		return productRepository.findByNameContaining(name);
	}

	public Optional<Product> findById(long id) {
		return productRepository.findById(id);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public void deleteByid(long id) {
		productRepository.deleteById(id);
	}
}
