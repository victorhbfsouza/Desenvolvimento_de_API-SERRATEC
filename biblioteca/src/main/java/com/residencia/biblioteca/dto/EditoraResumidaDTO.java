package com.residencia.biblioteca.dto;

import java.util.List;

import com.residencia.biblioteca.entities.Editora;

public class EditoraResumidaDTO {

	private Integer codigoEditora;
	private String nome;
	private List<LivroResumidoDTO> listaLivrosResDto;
	
	
	public EditoraResumidaDTO(Editora editora, List<LivroResumidoDTO> listaLivroResDto) {
		super();
		this.codigoEditora = editora.getCodigoEditora();
		this.nome = editora.getNome();
		this.listaLivrosResDto = listaLivroResDto;
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
	
}
