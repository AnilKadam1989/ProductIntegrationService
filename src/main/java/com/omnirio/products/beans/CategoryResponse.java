package com.omnirio.products.beans;

import java.util.List;

public class CategoryResponse {

	private long id;
	
	private String name;
	
	private List<AttributeResponse> attributes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AttributeResponse> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<AttributeResponse> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "CategoryResponse [id=" + id + ", name=" + name + ", attributes=" + attributes + "]";
	}
	
}
