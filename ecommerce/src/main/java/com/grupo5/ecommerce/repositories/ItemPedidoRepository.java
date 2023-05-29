package com.grupo5.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.ecommerce.entities.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{
	
}
