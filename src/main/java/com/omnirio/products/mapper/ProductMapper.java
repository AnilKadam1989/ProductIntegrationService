package com.omnirio.products.mapper;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.omnirio.products.beans.CategoryResponse;
import com.omnirio.products.beans.ProductRequest;
import com.omnirio.products.beans.ProductResponse;
import com.omnirio.products.entity.Category;
import com.omnirio.products.entity.Product;

@Component
public class ProductMapper {

	@Autowired 
	private CategoryMapper categoryMapper;
	
	public Product mapRequestToEntity(Category category, @Valid ProductRequest productRequest) {
		Product product = new Product();
		product.setCategory(category);
		product.setIsActive(1);
		product.setProductName(productRequest.getName());
		return product;
	}

	public ProductResponse mapEntityToResponse(Product product) {
		ProductResponse productResponse = new ProductResponse();
		if(Objects.nonNull(product.getCategory())) {
			Category category = product.getCategory();
			CategoryResponse categoryResponse = categoryMapper.mapEntityToResponse(category);
			productResponse.setCategory(categoryResponse);
		}
		productResponse.setId(product.getProductId());
		productResponse.setName(product.getProductName());
		return productResponse;
	}

}
