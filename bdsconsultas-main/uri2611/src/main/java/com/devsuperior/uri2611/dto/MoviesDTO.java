package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.projections.MoviesProjection;

public class MoviesDTO {
	
	private Long id;
	private String name;
	

	public MoviesDTO() {
		
	}
	
	public MoviesDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public MoviesDTO(MoviesProjection projection) {
		id = projection.getId();
		name = projection.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MoviesDTO [id=" + id + ", name=" + name + "]";
	}
	
	

}
