package com.residencia.biblioteca.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "codigoLivro")
	private Integer codigolivro;
	
	@Column (name = "nomeLivro")
	private String nomelivro;
	
	@Column (name = "nomeAutor")
	private String nomeautor;
	
	@Column (name = "dataLancamento")
	private Date datalancamento;
	
	@Column (name = "codigoIsbn")
	private Integer codigoisbn;
	
									@ManyToOne
									@JoinColumn (name = "codigoeditora", referencedColumnName = "codigoeditora")
									private Editora editora;
									
									@ManyToOne
									@JoinColumn (name = "codigolivro", referencedColumnName = "codigolivro")
									private Emprestimo emprestimo;
	
	public Integer getCodigolivro() {
	return codigolivro;
	}

	public void setCodigolivro(Integer codigolivro) {
		this.codigolivro = codigolivro;
	}

	public String getNomelivro() {
		return nomelivro;
	}

	public void setNomelivro(String nomelivro) {
		this.nomelivro = nomelivro;
	}

	public String getNomeautor() {
		return nomeautor;
	}

	public void setNomeautor(String nomeautor) {
		this.nomeautor = nomeautor;
	}

	public Date getDatalancamento() {
		return datalancamento;
	}

	public void setDatalancamento(Date datalancamento) {
		this.datalancamento = datalancamento;
	}

	public Integer getCodigoisbn() {
		return codigoisbn;
	}

	public void setCodigoisbn(Integer codigoisbn) {
		this.codigoisbn = codigoisbn;
	}

										public Editora getEditora() {
											return editora;
										}

										public void setEditora(Editora editora) {
											this.editora = editora;
										}

										public Emprestimo getEmprestimo() {
											return emprestimo;
										}

										public void setEmprestimo(Emprestimo emprestimo) {
											this.emprestimo = emprestimo;
										}
										
}
