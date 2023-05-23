package com.residencia.biblioteca.exception;

public class AlunoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public AlunoNotFoundException(Integer id) {
		super("Não foi encontrado Aluno com o id = "+id);
	}
}