package com.residencia.biblioteca.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoEmprestimo")
	private Integer codigoemprestimo;
	
	@Column(name = "dataEmprestimo")
	private Date dataemprestimo;
	
	@Column(name = "dataEntrega")
	private Date dataentrega;
	
	@Column(name = "valorEmprestimo")
	private BigDecimal valoremprestimo;
	
	@ManyToOne
	@JoinColumn (name = "numeromatriculaaluno", referencedColumnName = "numeromatriculaaluno")
	private Aluno aluno;
	
									@OneToMany (mappedBy = "emprestimo")
									private List <Livro> livros;

	public Integer getCodigoemprestimo() {
		return codigoemprestimo;
	}

	public void setCodigoemprestimo(Integer codigoemprestimo) {
		this.codigoemprestimo = codigoemprestimo;
	}

		public Date getDataemprestimo() {
		return dataemprestimo;
	}

	public void setDataemprestimo(Date dataemprestimo) {
		this.dataemprestimo = dataemprestimo;
	}

	public Date getDataentrega() {
		return dataentrega;
	}

	public void setDataentrega(Date dataentrega) {
		this.dataentrega = dataentrega;
	}

	public BigDecimal getValoremprestimo() {
		return valoremprestimo;
	}

	public void setValoremprestimo(BigDecimal valoremprestimo) {
		this.valoremprestimo = valoremprestimo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

										public List<Livro> getLivros() {
											return livros;
											}
										
										public void setLivros(List<Livro> livros) {
											this.livros = livros;
											}
}
