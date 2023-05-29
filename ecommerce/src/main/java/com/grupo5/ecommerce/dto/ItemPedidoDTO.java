package com.grupo5.ecommerce.dto;

import java.math.BigDecimal;

public class ItemPedidoDTO {
	
	private Integer idItemPedido;
	
	private Integer quantidade;
	
	private BigDecimal precoVenda;
	
	private BigDecimal percentualDesconto;
	
	private BigDecimal valorBruto;
	
	private BigDecimal valorLiquido;
	
	private PedidoDTO pedido;
	
	private ProdutoDTO produto;

	public ItemPedidoDTO(Integer idItemPedido, Integer quantidade, BigDecimal precoVenda, BigDecimal percentualDesconto,
			BigDecimal valorBruto, BigDecimal valorLiquido, PedidoDTO pedido, ProdutoDTO produto) {
		super();
		this.idItemPedido = idItemPedido;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.percentualDesconto = percentualDesconto;
		this.valorBruto = valorBruto;
		this.valorLiquido = valorLiquido;
		this.pedido = pedido;
		this.produto = produto;
	}

	public ItemPedidoDTO() {
		super();
	}

	public Integer getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public BigDecimal getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
}
