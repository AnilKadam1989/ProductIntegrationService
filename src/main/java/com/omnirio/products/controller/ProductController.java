package com.omnirio.products.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.omnirio.products.beans.ProductRequest;
import com.omnirio.products.beans.ProductResponse;
import com.omnirio.products.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/product/{categoryId}", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<?> createProduct(
			@PathVariable @Min(1) Long categoryId,
			@Valid @RequestBody ProductRequest productRequest) {
		try {
			return new ResponseEntity<ProductResponse>(productService
					.createProduct(categoryId, productRequest),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<?> getProduct(@PathVariable @Min(1) Long productId) {
		try {
			return new ResponseEntity<ProductResponse>(productService
					.getProduct(productId),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
