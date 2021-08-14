package com.omnirio.products.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.omnirio.products.beans.CategoryRequest;
import com.omnirio.products.beans.CategoryResponse;
import com.omnirio.products.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping(value = "/category", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryResponse> createCategory(
			@Valid @RequestBody CategoryRequest categoryRequest) {
		return new ResponseEntity<CategoryResponse>(categoryService.createCategory(categoryRequest),
				HttpStatus.CREATED);
	}
	
}
