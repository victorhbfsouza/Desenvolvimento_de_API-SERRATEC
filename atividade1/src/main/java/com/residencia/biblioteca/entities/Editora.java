package com.residencia.biblioteca.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


//@JsonIdentityInfo(
//		generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "codigoEditora"
//		) 

@Entity
@Table(name = "editora")
public class Editora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoeditora")
	private Integer codigoEditora;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "imagem_nome")
	private String imagemNome;
	
	@Column(name = "imagem_filename")
	private String imagemFilename;
	
	@Column(name = "imagem_url")
	private String imagemURL;
	
	//relacoes
	
	@JsonManagedReference
	@OneToMany(mappedBy = "editora")
	private List<Livro> listaLivro;

	
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

	public String getImagemFilename() {
		return imagemFilename;
	}

	public void setImagemFilename(String imagemFilename) {
		this.imagemFilename = imagemFilename;
	}

	public String getImagemURL() {
		return imagemURL;
	}

	public void setImagemURL(String imagemURL) {
		this.imagemURL = imagemURL;
	}

	public List<Livro> getListaLivro() {
		return listaLivro;
	}

	public void setListaLivro(List<Livro> listaLivro) {
		this.listaLivro = listaLivro;
	}

}
