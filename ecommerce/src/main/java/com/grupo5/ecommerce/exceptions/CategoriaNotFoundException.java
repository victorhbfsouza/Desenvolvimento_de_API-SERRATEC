package com.grupo5.ecommerce.exceptions;

public class CategoriaNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public CategoriaNotFoundException(Integer id) {
		super("Não foi encontrado Categoria com o id = " + id);
	}
}
