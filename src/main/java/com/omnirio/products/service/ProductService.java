package com.omnirio.products.service;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.omnirio.products.beans.ProductRequest;
import com.omnirio.products.beans.ProductResponse;

public interface ProductService {

	ProductResponse createProduct(@Min(1) Long categoryId, @Valid ProductRequest productRequest) 
		throws Exception;

	ProductResponse getProduct(@Min(1) Long productId) throws Exception;

}
