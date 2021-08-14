package com.omnirio.products.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.omnirio.products.beans.AttributeRequest;
import com.omnirio.products.beans.AttributeResponse;
import com.omnirio.products.entity.Attribute;
import com.omnirio.products.entity.Category;

@Component
public class AttributeMapper {

	public Attribute mapRequestToEntity(Category category, @Valid AttributeRequest attributeRequest) {
		Attribute attribute = new Attribute();
		attribute.setCategory(category);
		attribute.setAttributeName(attributeRequest.getName());
		attribute.setAttributeValue(attributeRequest.getValue());
		return attribute;
	}

	public AttributeResponse mapEntityToResponse(Attribute attribute) {
		AttributeResponse attributeResponse = new AttributeResponse();
		attributeResponse.setId(attribute.getAttributeId());
		attributeResponse.setName(attribute.getAttributeName());
		attributeResponse.setValue(attribute.getAttributeValue());
		return attributeResponse;
	}

	public List<AttributeResponse> mapCategoryAttributes(Category category) {
		List<AttributeResponse> attributeResponse = new ArrayList<>();
		if(!CollectionUtils.isEmpty(category.getAttribute())) {
			List<Attribute> attributes = category.getAttribute();
			for(Attribute attribute: attributes) {
				attributeResponse.add(mapEntityToResponse(attribute));
			}
		}
		return attributeResponse;
	}

}
