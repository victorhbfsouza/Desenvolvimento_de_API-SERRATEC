package com.grupo5.ecommerce.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo5.ecommerce.entities.Produto;
import com.grupo5.ecommerce.exceptions.ProdutoNotFoundException;
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
		Produto produto = produtoRepository.findById(id).orElseThrow(()
				-> new ProdutoNotFoundException(id));
		
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

	   public Produto saveimagemProduto (String produto , MultipartFile file) throws IOException {
           Produto objProduto;
           try {
                ObjectMapper objMapper = new ObjectMapper();
                objProduto = objMapper.readValue(produto, Produto.class);
            } catch (IOException e) {
                throw new IOException("Não foi possivel dessa vez");
            } 
            Produto produto1 = new Produto(); 
            produto1.setNome(objProduto.getNome());
            produto1.setImagemDados(file.getBytes());
            produto1.setImagemNome(file.getName());
            produto1.setImagemTipo(file.getContentType());

            return produtoRepository.save(produto1);
       }
}
