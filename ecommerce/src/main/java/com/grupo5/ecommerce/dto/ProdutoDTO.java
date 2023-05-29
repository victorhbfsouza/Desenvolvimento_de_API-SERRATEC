package com.grupo5.ecommerce.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.grupo5.ecommerce.entities.Categoria;

public class ProdutoDTO {
	
	private Integer idProduto;
	
	private String nome;
	
	private String descricao;
	
	private Integer qtdEstoque;
	
	private Instant dataCadastro;

	private BigDecimal valorUnitario;

	private byte[] imagem; 

	private Categoria categoria;
	
	private Set<ItemPedidoDTO> pedidos = new HashSet<>();

	public ProdutoDTO(Integer idProduto, String nome, String descricao, Integer qtdEstoque, Instant dataCadastro,
			BigDecimal valorUnitario, byte[] imagem, Categoria categoria, Set<ItemPedidoDTO> pedidos) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.imagem = imagem;
		this.categoria = categoria;
		this.pedidos = pedidos;
	}

	public ProdutoDTO() {
		super();
		
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<ItemPedidoDTO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<ItemPedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}
	
}
