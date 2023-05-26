package com.grupo5.ecommerce.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "item_pedido")
public class Item_Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_item_pedido;
	
	@Column (name = "quantidade")
	private Integer quantidade;
	
	@Column (name = "preco_venda")
	private BigDecimal preco_venda;
	
	@Column (name = "percentual_desconto")
	private Double percentual_desconto;
	// ver o tipo de atributo percentual
	
	@Column (name = "valor_bruto")
	private BigDecimal valor_bruto;
	
	@Column (name = "valor_liquido")
	private BigDecimal valor_liquido;
	
	@ManyToOne
	@JoinColumn (name = "id_pedido", referencedColumnName = "id_pedido")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn (name = "id_produto", referencedColumnName = "id_produto")
	private Produto produto;

	public Integer getId_item_pedido() {
		return id_item_pedido;
	}

	public void setId_item_pedido(Integer id_item_pedido) {
		this.id_item_pedido = id_item_pedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(BigDecimal preco_venda) {
		this.preco_venda = preco_venda;
	}

	public Double getPercentual_desconto() {
		return percentual_desconto;
	}

	public void setPercentual_desconto(Double percentual_desconto) {
		this.percentual_desconto = percentual_desconto;
	}

	public BigDecimal getValor_bruto() {
		return valor_bruto;
	}

	public void setValor_bruto(BigDecimal valor_bruto) {
		this.valor_bruto = valor_bruto;
	}

	public BigDecimal getValor_liquido() {
		return valor_liquido;
	}

	public void setValor_liquido(BigDecimal valor_liquido) {
		this.valor_liquido = valor_liquido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
