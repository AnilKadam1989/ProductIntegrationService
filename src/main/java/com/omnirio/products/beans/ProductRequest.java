package com.omnirio.products.beans;

public class ProductRequest {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductRequest [name=" + name + "]";
	}
	
}
