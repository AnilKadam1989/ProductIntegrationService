package com.omnirio.products.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.omnirio.products.beans.AttributeRequest;
import com.omnirio.products.beans.AttributeResponse;
import com.omnirio.products.service.AttributeService;

@RestController
public class AttributeController {

	@Autowired
	private AttributeService attributeService;

	@PostMapping(value = "/attribute", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createCategoryAttribute(
			@PathVariable @Min(1) Long categoryId,
			@Valid @RequestBody AttributeRequest attributeRequest) {
		try {
			return new ResponseEntity<AttributeResponse>(attributeService
					.createCategoryAttribute(categoryId, attributeRequest),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/attribute", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCategoryAttribute(@PathVariable @Min(1) Long categoryId) {
		try {
			return new ResponseEntity<>(attributeService
					.getCategoryAttribute(categoryId),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
