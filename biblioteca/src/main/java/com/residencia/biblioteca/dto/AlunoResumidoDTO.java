package com.residencia.biblioteca.dto;

import java.util.List;

public class AlunoResumidoDTO {
	private String nome;
	private String cpf;
	private List<EmprestimoResumidoDTO> listaEmprestimoResDto;

	public AlunoResumidoDTO() {
		super();
	}

	public AlunoResumidoDTO(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public AlunoResumidoDTO(String nome, String cpf, List<EmprestimoResumidoDTO> listaEmprestimoResDto) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.listaEmprestimoResDto = listaEmprestimoResDto;
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

	public List<EmprestimoResumidoDTO> getListaEmprestimoResDto() {
		return listaEmprestimoResDto;
	}

	public void setListaEmprestimoResDto(List<EmprestimoResumidoDTO> listaEmprestimoResDto) {
		this.listaEmprestimoResDto = listaEmprestimoResDto;
	}
}