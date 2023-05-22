package com.residencia.biblioteca.dto;

import java.util.List;

public class EditoraResumidaDTO {

	private Integer codigoEditora;
	private String nome;
	private List<LivroResumidoDTO> listaLivros;
	
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
	public List<LivroResumidoDTO> getListaLivros() {
		return listaLivros;
	}
	public void setListaLivros(List<LivroResumidoDTO> listaLivros) {
		this.listaLivros = listaLivros;
	}
}
