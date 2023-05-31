package com.grupo5.ecommerce.dto;

public class RelatorioPedidoItemDTO {
	
	private Integer codigo_produto;
	private String nome_produto;
	private Double preco_venda;
	private Integer quantidade;
	private Double valor_bruto;
	private Double percentual_desconto;
	private Double valor_liquido;
	
	public RelatorioPedidoItemDTO() {
		super();
	}

	public RelatorioPedidoItemDTO(Integer codigo_produto, String nome_produto, Double preco_venda,
			Integer quantidade, Double valor_bruto, Double percentual_desconto, Double valor_liquido) {
		super();
		this.codigo_produto = codigo_produto;
		this.nome_produto = nome_produto;
		this.preco_venda = preco_venda;
		this.quantidade = quantidade;
		this.valor_bruto = valor_bruto;
		this.percentual_desconto = percentual_desconto;
		this.valor_liquido = valor_liquido;
	}

	public Integer getCodigo_produto() {
		return codigo_produto;
	}

	public void setCodigo_produto(Integer codigo_produto) {
		this.codigo_produto = codigo_produto;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public Double getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(Double preco_venda) {
		this.preco_venda = preco_venda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor_bruto() {
		return valor_bruto;
	}

	public void setValor_bruto(Double valor_bruto) {
		this.valor_bruto = valor_bruto;
	}

	public Double getPercentual_desconto() {
		return percentual_desconto;
	}

	public void setPercentual_desconto(Double percentual_desconto) {
		this.percentual_desconto = percentual_desconto;
	}

	public Double getValor_liquido() {
		return valor_liquido;
	}

	public void setValor_liquido(Double valor_liquido) {
		this.valor_liquido = valor_liquido;
	}
}
