package com.grupo5.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.ecommerce.entities.Pedido;

public interface PedidoRepository extends JpaRepository <Pedido, Integer> {

}
