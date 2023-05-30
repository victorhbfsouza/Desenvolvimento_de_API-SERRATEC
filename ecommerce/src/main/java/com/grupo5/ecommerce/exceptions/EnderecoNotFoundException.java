package com.grupo5.ecommerce.exceptions;

public class EnderecoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public EnderecoNotFoundException(Integer id) {
		super("Não foi encontrado Endereco com o id = " + id);
	}
}
