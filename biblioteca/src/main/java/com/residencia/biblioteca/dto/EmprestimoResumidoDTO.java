package com.residencia.biblioteca.dto;

import java.util.Date;
import java.util.List;

public class EmprestimoResumidoDTO {
	
	private Date dataEmprestimo;
	private Date dataEntrega;
	//Faz parte de uma outra entidade
	private String nomeLivro;
	//Usado pelo professor
	private LivroResumidoDTO livroResumidoDTO;
	
	public EmprestimoResumidoDTO() {
		super();
	}
	
	//Usado pelo professor
	public EmprestimoResumidoDTO(Date dataEmprestimo, Date dataEntrega, LivroResumidoDTO livroResumidoDTO) {
		super();
		this.dataEmprestimo = dataEmprestimo;
		this.dataEntrega = dataEntrega;
		this.livroResumidoDTO = livroResumidoDTO;
	}

	public EmprestimoResumidoDTO(Date dataEmprestimo, Date dataEntrega) {
		super();
		this.dataEmprestimo = dataEmprestimo;
		this.dataEntrega = dataEntrega;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
}
