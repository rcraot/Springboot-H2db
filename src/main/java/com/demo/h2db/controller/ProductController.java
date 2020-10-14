package com.demo.h2db.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.demo.h2db.entity.Product;
import com.demo.h2db.model.Products;
import com.demo.h2db.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService service;

	/**
	 * method to fetch list of products.
	 * <Products> Wrapper class created to set List of products and return the
	 * response in a valid JSON format Products products = new Products();
	 * products.setProducts(list);
	 * 
	 */
	@GetMapping()
	public ResponseEntity<Products> getProducts() {
		List<Product> list = service.getAllProducts();
		Products products = new Products();
		products.setProducts(list);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	/**
	 * method to fetch the product details of given id. 
	 * (@PathVariable("id") Long id) is used to fetch the id provided in URL
	 * Ex: http://localhost:8082/api/products/2
	 * 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
		Product product = service.getProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	/**
	 * method to create new Product.
	 * 
	 * @RequestBody is used to pass the product object to save 
	 * (@RequestBody Product Product)
	 * 
	 */
	@PostMapping()
	public ResponseEntity<Product> createProduct(@RequestBody Product Product) {
		Product createdProduct = service.createProduct(Product);
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}

	/**
	 * method to update an existing Product.
	 * 
	 * @PathVariable and @RequestBody annotations are used to pass the product
	 *  object and id of the product to be updated.
	 *  (@PathVariable("id") Long id, @RequestBody Product product)
	 * 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		product.setId(id);
		Product updatedProduct = service.updateProductById(product);
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}

	/**
	 * method to delete a Product.
	 * 
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") final Long id) {
		service.deleteProductById(id);
		return new ResponseEntity<>("Product deleted succesfully.", HttpStatus.OK);
	}

}
