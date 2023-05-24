package com.residencia.biblioteca.dto;

import java.util.Date;

public class EmprestimoResumidoDTO {
	
	private Date dataEmprestimo;
	private Date dataEntrega;
	private String nomeLivro;
	
	public EmprestimoResumidoDTO() {
		super();
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
