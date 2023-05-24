package com.residencia.biblioteca.dto;

import java.util.List;

public class AlunoResumidoDTO {
	
	private String nome;
	private String cpf;
	private List<EmprestimoResumidoDTO> listaEmprestimosResDTO;
	
	public AlunoResumidoDTO() {
		super();
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

	public List<EmprestimoResumidoDTO> getListaEmprestimosResDTO() {
		return listaEmprestimosResDTO;
	}

	public void setListaEmprestimosResDTO(List<EmprestimoResumidoDTO> listaEmprestimosResDTO) {
		this.listaEmprestimosResDTO = listaEmprestimosResDTO;
	}

}
