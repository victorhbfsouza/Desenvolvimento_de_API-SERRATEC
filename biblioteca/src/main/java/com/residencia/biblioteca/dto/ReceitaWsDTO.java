package com.residencia.biblioteca.dto;

public class ReceitaWsDTO {
	
	private String nome;
	private String situacao;
	private String tipo;
	private String logradouro;
	private String complemento;
	private String numero;
	private String bairro;
	private String uf;
	private String cep;
	private String email;
	public ReceitaWsDTO() {
		super();
	}
	public ReceitaWsDTO(String nome, String situacao, String tipo, String logradouro, String complemento, String numero,
			String bairro, String uf, String cep, String email) {
		super();
		this.nome = nome;
		this.situacao = situacao;
		this.tipo = tipo;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.bairro = bairro;
		this.uf = uf;
		this.cep = cep;
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ReceitaWsDTO [nome=" + nome + ", situacao=" + situacao + ", tipo=" + tipo + ", logradouro=" + logradouro
				+ ", complemento=" + complemento + ", numero=" + numero + ", bairro=" + bairro + ", uf=" + uf + ", cep="
				+ cep + ", email=" + email + "]";
	}
	
}
