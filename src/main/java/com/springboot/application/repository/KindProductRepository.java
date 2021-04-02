package com.springboot.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.application.model.KindProduct;

public interface KindProductRepository extends JpaRepository<KindProduct, Long> {
	List<KindProduct> findByKindName(String kindName);
	public KindProduct findByIdKind(long idKind);
	//KindProduct findByKindName2(String kindName);
}
