package com.residencia.biblioteca.dto;

import java.util.List;

public class AlunoResumidoDTO {
	
	private String nome;
	private String cpf;
	private List<EmprestimoResumidoDTO> listaEmprestimosDTO;
	
	public AlunoResumidoDTO() {
		super();
	}

	//Usado pelo professor
	public AlunoResumidoDTO(String nome, String cpf, List<EmprestimoResumidoDTO> listaEmprestimosDTO) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.listaEmprestimosDTO = listaEmprestimosDTO;
	}

	public AlunoResumidoDTO(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

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

	public List<EmprestimoResumidoDTO> getlistaEmprestimosDTO() {
		return listaEmprestimosDTO;
	}

	public void setlistaEmprestimosDTO(List<EmprestimoResumidoDTO> listaEmprestimosDTO) {
		this.listaEmprestimosDTO = listaEmprestimosDTO;
	}
}
