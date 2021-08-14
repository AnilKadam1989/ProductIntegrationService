package com.omnirio.products.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.omnirio.products.beans.AttributeResponse;
import com.omnirio.products.beans.CategoryRequest;
import com.omnirio.products.beans.CategoryResponse;
import com.omnirio.products.entity.Attribute;
import com.omnirio.products.entity.Category;

@Component
public class CategoryMapper {

	public Category mapRequestToEntity(CategoryRequest categoryRequest) {
		Category category = new Category();
		category.setCategoryName(categoryRequest.getName());
		category.setIsActive(1);
		return category;
	}
	
	public CategoryResponse mapEntityToResponse(Category category) {
		CategoryResponse categoryResponse = new CategoryResponse();
		categoryResponse.setId(category.getCategoryid());
		categoryResponse.setName(category.getCategoryName());
		List<Attribute> attributes = category.getAttribute();
		if(!CollectionUtils.isEmpty(attributes)) {
			List<AttributeResponse> attributeResponseList = new ArrayList<>();
			for(Attribute attribute: attributes) {
				AttributeResponse attributeResponse = new AttributeResponse();
				attributeResponse.setId(attribute.getAttributeId());
				attributeResponse.setName(attribute.getAttributeName());
				attributeResponse.setValue(attribute.getAttributeValue());
				attributeResponseList.add(attributeResponse);
			}
			categoryResponse.setAttributes(attributeResponseList);
		}
		return categoryResponse;
	}
}
