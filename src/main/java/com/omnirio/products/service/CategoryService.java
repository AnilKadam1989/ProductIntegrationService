package com.omnirio.products.service;

import javax.validation.Valid;

import com.omnirio.products.beans.CategoryRequest;
import com.omnirio.products.beans.CategoryResponse;

public interface CategoryService {

	CategoryResponse createCategory(@Valid CategoryRequest categoryRequest);

}
