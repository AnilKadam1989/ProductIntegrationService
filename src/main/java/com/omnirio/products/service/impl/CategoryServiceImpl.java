package com.omnirio.products.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnirio.products.beans.CategoryRequest;
import com.omnirio.products.beans.CategoryResponse;
import com.omnirio.products.entity.Category;
import com.omnirio.products.mapper.CategoryMapper;
import com.omnirio.products.repository.CategoryRepository;
import com.omnirio.products.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public CategoryResponse createCategory(@Valid CategoryRequest categoryRequest) {
		Category category = categoryRepository.save(categoryMapper.mapRequestToEntity(categoryRequest));
		return categoryMapper.mapEntityToResponse(category);
	}

}
