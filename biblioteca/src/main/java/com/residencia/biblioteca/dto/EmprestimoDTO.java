package com.residencia.biblioteca.dto;

import java.math.BigDecimal;
import java.util.Date;

public class EmprestimoDTO {
	
	private Integer codigoEmprestimo;	
	private Date dataEmprestimo;
	private Date dataEntrega;
	private String nomeLivro;
	private BigDecimal valorEmprestimo;
	private AlunoDTO aluno;
	private LivroDTO livro;
	
	public EmprestimoDTO() {
		super();
	}

	public EmprestimoDTO(Integer codigoEmprestimo, Date dataEmprestimo, Date dataEntrega, String nomeLivro,
			BigDecimal valorEmprestimo, AlunoDTO aluno, LivroDTO livro) {
		super();
		this.codigoEmprestimo = codigoEmprestimo;
		this.dataEmprestimo = dataEmprestimo;
		this.dataEntrega = dataEntrega;
		this.nomeLivro = nomeLivro;
		this.valorEmprestimo = valorEmprestimo;
		this.aluno = aluno;
		this.livro = livro;
	}

	public Integer getCodigoEmprestimo() {
		return codigoEmprestimo;
	}

	public void setCodigoEmprestimo(Integer codigoEmprestimo) {
		this.codigoEmprestimo = codigoEmprestimo;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public BigDecimal getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(BigDecimal valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public AlunoDTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoDTO aluno) {
		this.aluno = aluno;
	}

	public LivroDTO getLivro() {
		return livro;
	}

	public void setLivro(LivroDTO livro) {
		this.livro = livro;
	}	
}
