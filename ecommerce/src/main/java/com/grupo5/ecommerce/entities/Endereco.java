package com.grupo5.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_endereco;
	
	@Column (name = "cep")
	private String cep;
	
	@Column (name = "rua")
	private String rua;
	
	@Column (name = "bairro")
	private String bairro;
	
	@Column (name = "cidade")
	private String cidade;
	
	@Column (name = "numero")
	private Integer numero;
	
	@Column (name = "complemento")
	private String complemento;
	
	@Column (name = "uf")
	private String uf;
	
	@OneToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	private Cliente cliente;

	public Integer getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(Integer id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
