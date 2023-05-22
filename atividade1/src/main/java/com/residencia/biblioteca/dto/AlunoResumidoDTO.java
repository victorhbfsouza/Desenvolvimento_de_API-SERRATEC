package com.residencia.biblioteca.dto;

import java.util.List;

public class AlunoResumidoDTO {

	private String nome;
	private String cpf;
	private List<String> livroEmprestado;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<String> getLivroEmprestado() {
		return livroEmprestado;
	}
	public void setLivroEmprestado(List<String> livroEmprestado) {
		this.livroEmprestado = livroEmprestado;
	}
	
}
