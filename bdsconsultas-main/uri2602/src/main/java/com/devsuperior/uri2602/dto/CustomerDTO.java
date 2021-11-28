package com.devsuperior.uri2602.dto;

import com.devsuperior.uri2602.CustomerProjection.CustomerProjection;

public class CustomerDTO {
	
	private String name;
	
	public CustomerDTO() {
	
	}

	public CustomerDTO(String name) {
		this.name = name;
	}

	public CustomerDTO(CustomerProjection entity) {
		name = entity.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CustomerDTO [name=" + name + "]";
	}
	
	

}
