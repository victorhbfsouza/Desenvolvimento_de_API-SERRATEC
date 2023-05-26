package com.grupo5.ecommerce.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cliente;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "nome_completo")
	private String nome_completo;
	
	@Column (name = "cpf")
	private String cpf;
	//ver atributo Integer ou String
	
	@Column (name = "telefone")
	private String telefone;
	//ver atributo Integer ou String
	
	@Column (name = "data_nascimento")
	private Date data_nascimento;
	
	@OneToMany (mappedBy = "pedido")
	private List<Pedido> Pedidos;
	
	@OneToOne(mappedBy = "cliente")
	private Endereco endereco;

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public List<Pedido> getPedidos() {
		return Pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		Pedidos = pedidos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
