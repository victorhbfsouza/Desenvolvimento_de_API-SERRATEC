package com.grupo5.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.grupo5.ecommerce.entities.Produto;
import com.grupo5.ecommerce.repositories.ProdutoRepository;

public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> getAllProdutos() {
		return produtoRepository.findAll();
	}
	
	public Produto getProdutoById(Integer id) {
		return produtoRepository.findById(id).orElse(null);
	}
	
	public Produto saveProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	
	public Produto updateProduto(Produto produto, Integer id) {
		return produtoRepository.save(produto);
	}
	
	public void deleteProduto(Integer id) {
		produtoRepository.deleteById(id);
	}
	
	public Boolean delProduto(Integer id) {
		produtoRepository.deleteById(id);
		Produto produtoDeletado = produtoRepository.findById(id).orElse(null);
		if (null == produtoDeletado) {
			return true;
		}else {
			return false;
		}
	}
}

