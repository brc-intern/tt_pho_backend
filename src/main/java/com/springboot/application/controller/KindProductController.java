package com.springboot.application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.application.model.KindProduct;
import com.springboot.application.service.KindProductService;
import com.springboot.application.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/kindproduct")
public class KindProductController {
	@Autowired
	KindProductService service;
	@Autowired
	ProductService service2;
	@PostMapping("/create")
	public KindProduct postKindProduct(@RequestBody KindProduct kindProduct) {
		KindProduct kk = new KindProduct();
		String check = kk.setKindName(kindProduct.getKindName());
		System.out.println(check);
		List<KindProduct> kind = service.findByKindName(check);
		KindProduct kind2 = new KindProduct();
		if(kind == null) {
			kind2= service.ListKind(new KindProduct(kindProduct.getIdKind(), kindProduct.getKindName(), kindProduct.getListProduct()));
		}else {
			service2.save(kindProduct.getListProduct());
		}
		return kind2;
	}
	
	@GetMapping("/getkind/{idKind}")
	public ResponseEntity<KindProduct> getKindProductById(@PathVariable("idKind") long idKind) {
		Optional<KindProduct> kindData = service.findById(idKind);

		if (kindData.isPresent()) {
			return new ResponseEntity<>(kindData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/getallkind")
	public ResponseEntity<List<KindProduct>> getAllKind(@RequestParam(required = false) String kindName){
		try {
			List<KindProduct> kind = new ArrayList<KindProduct>();
			if(kindName==null) {
				service.findAll().forEach(kind::add);
			}else {
				service.findByKindName(kindName).forEach(kind::add);
			}
			if(kind.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(kind, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
