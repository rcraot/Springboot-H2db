package com.demo.h2db.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.h2db.entity.Product;
import com.demo.h2db.exception.ProductNotFoundException;
import com.demo.h2db.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	/**
	 * Get All Products.
	 * 
	 * @return List of all products.
	 */
	@Override
	public List<Product> getAllProducts() {

		return this.repository.findAll();
	}

	/**
	 * Create Product.
	 * 
	 * @return created product
	 */
	@Override
	public Product createProduct(final Product Product) {
		return this.repository.save(Product);
	}

	/**
	 * Update Product.
	 * 
	 * @param id
	 * @return Updated product
	 */
	@Override
	public Product updateProductById(Product product) {

		Optional<Product> productDb = this.repository.findById(product.getId());

		if (productDb.isPresent()) {
			Product productUpdate = productDb.get();
			productUpdate.setName(product.getName());
			productUpdate.setDescription(product.getDescription());
			this.repository.save(productUpdate);
			return productUpdate;
		} else {
			throw new ProductNotFoundException("Record not found with id.", product.getId());
		}
	}

	/**
	 * Get Product By Id.
	 * 
	 * @param id
	 * @return product
	 */
	@Override
	public Product getProductById(final Long id) {

		Optional<Product> product = this.repository.findById(id);

		if (product.isPresent()) {
			return product.get();
		} else {
			throw new ProductNotFoundException("Record not found with id.", id);
		}

	}

	/**
	 * Delete Product by Id.
	 * 
	 * @param id
	 */
	@Override
	public void deleteProductById(final Long id) {
		Optional<Product> productDb = this.repository.findById(id);

		if (productDb.isPresent()) {
			this.repository.delete(productDb.get());
		} else {
			throw new ProductNotFoundException("Record not found with id.", id);
		}
	}

}
