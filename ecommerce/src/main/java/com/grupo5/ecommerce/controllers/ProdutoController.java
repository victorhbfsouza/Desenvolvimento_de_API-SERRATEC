package com.grupo5.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo5.ecommerce.entities.Produto;
import com.grupo5.ecommerce.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        return new ResponseEntity<>(produtoService.getAllProdutos(),
                HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable Integer id) {
        Produto produtoResponse = produtoService.getProdutoById(id);
        if(null == produtoResponse)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(produtoResponse, HttpStatus.OK);
    }
    
    
    @PostMapping
    public ResponseEntity<Produto> saveProduto(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.saveProduto(produto),HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) {
    	if(produtoService.getProdutoById(produto.getIdProduto()) != null) {
            return new ResponseEntity<> (produtoService.updateProduto(produto),
                    HttpStatus.OK);
        }
        else {
            return new ResponseEntity<> (produto,
                    HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delProduto(@PathVariable Integer id) {
        Boolean resp = produtoService.delProduto(id);
        if(resp)
        	return new ResponseEntity<>(resp,HttpStatus.OK);
        else
        	return new ResponseEntity<>(resp,HttpStatus.NOT_MODIFIED);
    }
}
