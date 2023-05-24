package com.residencia.biblioteca.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/*
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "codigoEditora"
		)*/
@Entity
@Table (name = "editora")
public class Editora {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "codigoeditora")
	private Integer codigoEditora;
	
	@Column (name = "nome")
	private String nome;
	
	@Column (name = "imagem_nome")
	private String imagemNome;
	
	@Column (name = "imagem_filename")
	private String imagemFileName;
	
	@Column (name = "imagem_url")
	private String imagemUrl;
	
	@Column (name = "cnpj")
	private String cnpj;
	
	//@JsonManagedReference (value = "editora-back")
	@OneToMany (mappedBy = "editora")
	private List<Livro> livros;

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

	public String getImagemNome() {
		return imagemNome;
	}

	public void setImagemNome(String imagemNome) {
		this.imagemNome = imagemNome;
	}

	public String getImagemFileName() {
		return imagemFileName;
	}

	public void setImagemFileName(String imagemFileName) {
		this.imagemFileName = imagemFileName;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
	
}
