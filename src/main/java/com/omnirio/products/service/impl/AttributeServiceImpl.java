package com.omnirio.products.service.impl;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnirio.products.beans.AttributeRequest;
import com.omnirio.products.beans.AttributeResponse;
import com.omnirio.products.entity.Attribute;
import com.omnirio.products.entity.Category;
import com.omnirio.products.mapper.AttributeMapper;
import com.omnirio.products.repository.AttributeRepository;
import com.omnirio.products.repository.CategoryRepository;
import com.omnirio.products.service.AttributeService;

@Service
public class AttributeServiceImpl implements AttributeService {

	@Autowired
	private AttributeRepository attributeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private AttributeMapper attributeMapper;
	
	@Override
	public AttributeResponse createCategoryAttribute(@Min(1) Long categoryId,
			@Valid AttributeRequest attributeRequest) throws Exception {
		Category category = categoryRepository.findByCategoryidAndIsActive(categoryId, 1);
		AttributeResponse attributeResponse = null;
		if(Objects.nonNull(category)) {
			Attribute attribute = attributeMapper.mapRequestToEntity(category, attributeRequest);
			attribute = attributeRepository.save(attribute);
			attributeResponse = attributeMapper.mapEntityToResponse(attribute);
		} else {
			throw new Exception("Category Not Found.");
		}
		return attributeResponse;
	}

	@Override
	public List<AttributeResponse> getCategoryAttribute(@Min(1) Long categoryId) throws Exception {
		Category category = categoryRepository.findByCategoryidAndIsActive(categoryId, 1);
		List<AttributeResponse> attributeResponse = null;
		if(Objects.nonNull(category)) {
			attributeResponse = attributeMapper.mapCategoryAttributes(category);
		} else {
			throw new Exception("Category Not Found.");
		}
		return attributeResponse;
	}

}
