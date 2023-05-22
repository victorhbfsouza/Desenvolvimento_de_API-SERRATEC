package com.residencia.biblioteca.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//@JsonIdentityInfo(
//		generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "codigoLivro"
//		) 

@Entity
@Table(name = "livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigolivro")
	private Integer codigoLivro;
	
	@Column(name = "nomelivro")
	private String nomeLivro;
	
	@Column(name = "nomeautor")
	private String nomeAutor;
	
	@Column(name = "datalancamento")
	private Date dataLancamento;
	
	@Column(name = "codigoisbn")
	private Integer codigoISBN;

	@JsonManagedReference(value = "livro-emprestimo")
	@OneToMany(mappedBy = "livro")
	private List<Emprestimo> listaEmprestimo;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "codigoeditora", referencedColumnName = "codigoeditora")
	private Editora editora;

	
	public Integer getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(Integer codigoLivro) {
		this.codigoLivro = codigoLivro;
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

	public Integer getCodigoISBN() {
		return codigoISBN;
	}

	public void setCodigoISBN(Integer codigoISBN) {
		this.codigoISBN = codigoISBN;
	}

	public List<Emprestimo> getListaEmprestimo() {
		return listaEmprestimo;
	}

	public void setListaEmprestimo(List<Emprestimo> listaEmprestimo) {
		this.listaEmprestimo = listaEmprestimo;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

}
