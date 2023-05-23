package com.residencia.biblioteca.dto;

import java.util.List;

public class EditoraResumidaDTO {
	private Integer codigoEditora;
	private String nome;
	private String cnpj;
	private List<LivroResumidoDTO> listaLivrosResDto;
	
	public EditoraResumidaDTO() {
		super();
	}
	
	public EditoraResumidaDTO(Integer codigoEditora, String nome) {
		super();
		this.codigoEditora = codigoEditora;
		this.nome = nome;
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

	public List<LivroResumidoDTO> getListaLivrosResDto() {
		return listaLivrosResDto;
	}

	public void setListaLivrosResDto(List<LivroResumidoDTO> listaLivrosResDto) {
		this.listaLivrosResDto = listaLivrosResDto;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}