package com.example.model.to;

import java.io.Serializable;

public class CategoryTO implements Serializable {

	private static final long serialVersionUID = -8082204208406288212L;

	private String categoryKey;
	private String categoryValue;

	public String getCategoryKey() {
		return categoryKey;
	}

	public void setCategoryKey(String categoryKey) {
		this.categoryKey = categoryKey;
	}

	public String getCategoryValue() {
		return categoryValue;
	}

	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}

}
