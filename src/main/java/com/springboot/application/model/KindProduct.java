package com.springboot.application.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "kind")
public class KindProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idkind")
	private long idKind;
	@Column(name = "kindname")
	private String kindName;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idKind", referencedColumnName = "idkind")
	private Set<Product> listProduct;
	

	public KindProduct() {
		super();
	}



	public KindProduct(long idKind, String kindName, Set<Product> listProduct) {
		super();
		this.idKind = idKind;
		this.kindName = kindName;
		this.listProduct = listProduct;
	}
	
	

	public KindProduct(Set<Product> listProduct) {
		super();
		this.listProduct = listProduct;
	}



	public Set<Product> getListProduct() {
		return listProduct;
	}


	public void setListProduct(Set<Product> listProduct) {
		this.listProduct = listProduct;
	}


	public long getIdKind() {
		return idKind;
	}


	public void setIdKind(long idKind) {
		this.idKind = idKind;
	}


	public String getKindName() {
		return kindName;
	}


	public String setKindName(String kindName) {
		return this.kindName = kindName;
	}

	
		
}
