package com.grupo5.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.ecommerce.entities.Produto;
import com.grupo5.ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> getAllProdutos() {
		List<Produto> produtos = produtoRepository.findAll();
				
		return produtos;
	}
	
	public Produto getProdutoById(Integer id) {
		Produto produto = produtoRepository.findById(id).orElse(null);
		
		if(produto==null)
			return null;
		
		return produto;
		
	}
	
	public Produto saveProduto(Produto produto) {
		return produtoRepository.save(produto);
		 
	}
	
	public Produto updateProduto(Produto produto) {
	
		return produtoRepository.save(produto);
		
		
	}
	
	   public Boolean delProduto(Integer id) {
		  if(produtoRepository.findById(id).orElse(null)!=null) {
			  produtoRepository.deleteById(id);
			  if(produtoRepository.findById(id).orElse(null)==null)
				  return true;
		     else
		    	 return false;
		  }
		    else return false;
	    	  
	      }
	

}
