package com.omnirio.products.beans;

public class AttributeResponse {

	private long id;
	
	private String name;
	
	private String value;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "AttributeResponse [id=" + id + ", name=" + name + ", value=" + value + "]";
	}
	
}
