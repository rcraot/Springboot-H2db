package com.demo.h2db.model;

import java.util.List;

import com.demo.h2db.entity.Product;

public class Products {

	private List<Product> products;

	public Products() {

	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
