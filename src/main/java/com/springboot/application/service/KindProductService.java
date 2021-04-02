package com.springboot.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.application.model.KindProduct;
import com.springboot.application.repository.KindProductRepository;

@Service
public class KindProductService {
	@Autowired
	KindProductRepository kindProductRepository;

	public List<KindProduct> findByKindName(String kindName) {
		return kindProductRepository.findByKindName(kindName);
	}

	public Optional<KindProduct> findById(long id) {
		return kindProductRepository.findById(id);
	}

	public KindProduct ListKind(KindProduct kind) {
		return kindProductRepository.save(kind);
	}

	public void deleteById(long id) {
		kindProductRepository.deleteById(id);
	}

	public List<KindProduct> findAll() {
		return kindProductRepository.findAll();
	}
	
	public KindProduct findByIdkind(long idKind) {
		return kindProductRepository.findByIdKind(idKind);
	}
//	public KindProduct findKindName(String kindName) {
//		return kindProductRepository.findByKindName2(kindName);
//	}
}
