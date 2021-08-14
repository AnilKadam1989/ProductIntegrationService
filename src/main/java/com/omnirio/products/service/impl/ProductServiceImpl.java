package com.omnirio.products.service.impl;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnirio.products.beans.ProductRequest;
import com.omnirio.products.beans.ProductResponse;
import com.omnirio.products.entity.Category;
import com.omnirio.products.entity.Product;
import com.omnirio.products.mapper.ProductMapper;
import com.omnirio.products.repository.CategoryRepository;
import com.omnirio.products.repository.ProductRepository;
import com.omnirio.products.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductMapper productMapper;
	
	
	@Override
	public ProductResponse createProduct(@Min(1) Long categoryId, @Valid ProductRequest productRequest) throws Exception {
		Category category = categoryRepository.findByCategoryidAndIsActive(categoryId, 1);
		if(Objects.nonNull(category)) {
			Product product = productMapper.mapRequestToEntity(category, productRequest);
			product = productRepository.save(product);
			return productMapper.mapEntityToResponse(product);
		} else {
			throw new Exception("Category Not Found.");
		}
	}
	
	@Override
	public ProductResponse getProduct(@Min(1) Long productId) throws Exception {
		Product product = productRepository.findByProductIdAndIsActive(productId, 1);
		if(Objects.nonNull(product)) {
			return productMapper.mapEntityToResponse(product);
		} else {
			throw new Exception("Category Not Found.");
		}
	}

}
