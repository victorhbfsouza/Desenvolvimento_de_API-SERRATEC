package com.grupo5.ecommerce.dto;

import java.util.List;


public class CategoriaDTO {

private Integer idCategoria;

private String nome;
	
private String descricao;
	
private List<ProdutoDTO> produtos;


public CategoriaDTO() {
	super();

}

public CategoriaDTO(Integer idCategoria, String nome, String descricao, List<ProdutoDTO> produtos) {
	super();
	this.idCategoria = idCategoria;
	this.nome = nome;
	this.descricao = descricao;
	this.produtos = produtos;
}

public Integer getIdCategoria() {
	return idCategoria;
}

public void setIdCategoria(Integer idCategoria) {
	this.idCategoria = idCategoria;
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

public List<ProdutoDTO> getProdutos() {
	return produtos;
}

public void setProdutos(List<ProdutoDTO> produtos) {
	this.produtos = produtos;
} 
	
}
