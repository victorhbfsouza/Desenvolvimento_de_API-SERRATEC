package com.grupo5.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.ecommerce.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
}
