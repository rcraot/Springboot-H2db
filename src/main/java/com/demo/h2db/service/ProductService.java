package com.demo.h2db.service;

import java.util.List;

import com.demo.h2db.entity.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(Long id);

	Product createProduct(Product Product);

	Product updateProductById(Product ProductToUpdate);

	void deleteProductById(Long id);

}
