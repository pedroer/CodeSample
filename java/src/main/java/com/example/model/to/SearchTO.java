package com.example.model.to;

import java.io.Serializable;

public class SearchTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String searchTerm;
	private String city;
	private String state;
	private String category;

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
