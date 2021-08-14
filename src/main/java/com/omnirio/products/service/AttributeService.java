package com.omnirio.products.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import com.omnirio.products.beans.AttributeRequest;
import com.omnirio.products.beans.AttributeResponse;

public interface AttributeService {

	AttributeResponse createCategoryAttribute(@Min(1) Long categoryId, @Valid AttributeRequest attributeRequest)
		throws Exception;

	List<AttributeResponse> getCategoryAttribute(@Min(1) Long categoryId) throws Exception;

}
