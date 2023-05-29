package com.grupo5.ecommerce.dto;

import com.grupo5.ecommerce.entities.RoleEnum;

public class RoleDTO {
	
	private Integer id;

	private RoleEnum name;

	public RoleDTO(Integer id, RoleEnum name) {
		super();
		this.id = id;
		this.name = name;
	}

	public RoleDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RoleEnum getName() {
		return name;
	}

	public void setName(RoleEnum name) {
		this.name = name;
	}

}
