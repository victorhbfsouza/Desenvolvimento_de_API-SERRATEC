package com.residencia.biblioteca.dto;

import java.util.Date;

public class EmprestimoResumidoDTO {
	private Date dataEmprestimo;
	private Date dataEntrega;
	private LivroResumidoDTO livroResumidoDto;
	
	public EmprestimoResumidoDTO() {
		super();
	}

	public EmprestimoResumidoDTO(Date dataEmprestimo, Date dataEntrega) {
		super();
		this.dataEmprestimo = dataEmprestimo;
		this.dataEntrega = dataEntrega;
	}
	
	public EmprestimoResumidoDTO(Date dataEmprestimo, Date dataEntrega, LivroResumidoDTO livroResumidoDto) {
		super();
		this.dataEmprestimo = dataEmprestimo;
		this.dataEntrega = dataEntrega;
		this.livroResumidoDto = livroResumidoDto;
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

	public LivroResumidoDTO getLivroResumidoDto() {
		return livroResumidoDto;
	}

	public void setLivroResumidoDto(LivroResumidoDTO livroResumidoDto) {
		this.livroResumidoDto = livroResumidoDto;
	}
}