package com.springboot.application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.application.model.Product;
import com.springboot.application.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping("/create")
	public Product postProduct(@RequestBody Product product) {
		String a = product.getImage();
		String b = "";
		b = a.substring(12);
		product.setImage(b);
		Product _product = service.ListProduct(new Product(product.getName(), product.getImage(), product.getPrice()));
		return _product;
	}

	@GetMapping("/getproduct/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
		Optional<Product> productData = service.findById(id);

		if (productData.isPresent()) {
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getallproduct")
	public ResponseEntity<List<Product>> getAllProduct(@RequestParam(required = false) String name) {
		try {
			List<Product> product = new ArrayList<Product>();
			if(name == null) {
				service.findAll().forEach(product::add);
			}else {
				service.findByName(name).forEach(product::add);
			}
			if(product.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Product> deleteAnimals(@PathVariable("id") long id) {
		System.out.println("Delete Animals with id = " + id + "....");
		service.deleteByid(id);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateAnimals(@PathVariable("id") long id, @RequestBody Product product) {
		System.out.println("Update Animal with id = " + id + "...");
		Optional<Product> productData = service.findById(id);
		

		if (productData.isPresent()) {
			String a = product.getImage();
			String b ="";
			b=a.substring(12);
			product.setImage(b);
			Product _product = productData.get();
			_product.setImage(product.getImage());
			_product.setName(product.getName());
			_product.setPrice(product.getPrice());
			return new ResponseEntity<>(service.ListProduct(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
