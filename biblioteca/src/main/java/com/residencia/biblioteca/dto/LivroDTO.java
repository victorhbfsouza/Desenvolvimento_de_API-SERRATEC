package com.residencia.biblioteca.dto;

import java.util.Date;
import java.util.List;

public class LivroDTO {
	
	private Integer codigoLivro;
	private String nomeLivro;
	private String nomeAutor;
	private Date dataLancamento;
	private Integer codigoIsbn;
	private EditoraDTO editora;
	private List<EmprestimoDTO> emprestimos;
	
	public LivroDTO() {
		super();		
	}

	public LivroDTO(Integer codigoLivro, String nomeLivro, String nomeAutor, Date dataLancamento, Integer codigoIsbn,
			EditoraDTO editora, List<EmprestimoDTO> emprestimos) {
		super();
		this.codigoLivro = codigoLivro;
		this.nomeLivro = nomeLivro;
		this.nomeAutor = nomeAutor;
		this.dataLancamento = dataLancamento;
		this.codigoIsbn = codigoIsbn;
		this.editora = editora;
		this.emprestimos = emprestimos;
	}

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

	public Integer getCodigoIsbn() {
		return codigoIsbn;
	}

	public void setCodigoIsbn(Integer codigoIsbn) {
		this.codigoIsbn = codigoIsbn;
	}

	public EditoraDTO getEditora() {
		return editora;
	}

	public void setEditora(EditoraDTO editora) {
		this.editora = editora;
	}

	public List<EmprestimoDTO> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<EmprestimoDTO> emprestimos) {
		this.emprestimos = emprestimos;
	}	
}
