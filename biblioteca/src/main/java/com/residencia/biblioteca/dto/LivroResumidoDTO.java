package com.residencia.biblioteca.dto;

import java.util.Date;

public class LivroResumidoDTO {
	private String nomeLivro;
	private String nomeAutor;
	private Date dataLancamento;
	
	public LivroResumidoDTO() {
		super();
	}

	public LivroResumidoDTO(String nomeLivro, String nomeAutor, Date dataLancamento) {
		super();
		this.nomeLivro = nomeLivro;
		this.nomeAutor = nomeAutor;
		this.dataLancamento = dataLancamento;
	}
	
	public LivroResumidoDTO(String nomeLivro) {
		super();
		this.nomeLivro = nomeLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
}