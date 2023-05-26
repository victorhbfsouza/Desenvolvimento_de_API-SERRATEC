package com.grupo5.ecommerce.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_produto;
	
	@Column (name = "nome")
	private String nome;
	
	@Column (name = "descricao")
	private String descricao;
	
	@Column (name = "qtd_estoque")
	private Integer qtd_estoque;
	
	@Column (name = "data_cadastro")
	private Date data_cadastro;
	
	@Column (name = "valor_unitario")
	private BigDecimal valor_unitario;
	
	@OneToMany (mappedBy = "categoria")
	private Integer id_categoria;
	
	@ManyToOne
	@JoinColumn (name = "id_categoria", referencedColumnName = "id_categoria")
	private Produto produto;
	
	@OneToMany (mappedBy = "produto")
	private List<Item_Pedido> item_pedidos;
	
	//imagem

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
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

	public Integer getQtd_estoque() {
		return qtd_estoque;
	}

	public void setQtd_estoque(Integer qtd_estoque) {
		this.qtd_estoque = qtd_estoque;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public BigDecimal getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(BigDecimal valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Item_Pedido> getItem_pedidos() {
		return item_pedidos;
	}

	public void setItem_pedidos(List<Item_Pedido> item_pedidos) {
		this.item_pedidos = item_pedidos;
	}

}
