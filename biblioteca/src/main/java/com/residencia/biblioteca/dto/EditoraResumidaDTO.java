package com.residencia.biblioteca.dto;

import java.util.List;

public class EditoraResumidaDTO {
	
	private Integer codigoEditora;
	private String nome;
	private List<LivroResumidoDTO> listaLivroResumido;
	
	public EditoraResumidaDTO() {
		super();
	}
	
	public Integer getCodigoEditora() {
		return codigoEditora;
	}
	public void setCodigoEditora(Integer codigoEditora) {
		this.codigoEditora = codigoEditora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<LivroResumidoDTO> getListaLivroResumido() {
		return listaLivroResumido;
	}

	public void setListaLivroResumido(List<LivroResumidoDTO> listaLivroResumido) {
		this.listaLivroResumido = listaLivroResumido;
	}
}
