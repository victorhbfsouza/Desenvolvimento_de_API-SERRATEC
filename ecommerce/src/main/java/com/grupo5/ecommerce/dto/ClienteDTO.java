package com.grupo5.ecommerce.dto;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ClienteDTO {
	
	private Integer numeroIdCliente;
	
	private Integer cpf;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	private Instant dataNascimento;
	
	private String username;
	
	private String password;
	
	private Set<RoleDTO> roles = new HashSet<>();

	private EnderecoDTO endereco; 

	private List<PedidoDTO> pedido; 

	public ClienteDTO(Integer numeroIdCliente, Integer cpf, String nome, String email, String telefone,
			Instant dataNascimento, String username, String password, Set<RoleDTO> roles, EnderecoDTO endereco,
			List<PedidoDTO> pedido) {
		super();
		this.numeroIdCliente = numeroIdCliente;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.endereco = endereco;
		this.pedido = pedido;
	}

	public ClienteDTO() {
		super();
		
	}

	public Integer getNumeroIdCliente() {
		return numeroIdCliente;
	}

	public void setNumeroIdCliente(Integer numeroIdCliente) {
		this.numeroIdCliente = numeroIdCliente;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public List<PedidoDTO> getPedido() {
		return pedido;
	}

	public void setPedido(List<PedidoDTO> pedido) {
		this.pedido = pedido;
	}
}
