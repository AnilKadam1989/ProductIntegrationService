package com.omnirio.products.beans;

public class ProductResponse {

	private long id;
	
	private String name;
	
	private CategoryResponse category;

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

	public CategoryResponse getCategory() {
		return category;
	}

	public void setCategory(CategoryResponse category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductResponse [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	
}
