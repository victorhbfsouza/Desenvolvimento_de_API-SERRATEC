package com.grupo5.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.ecommerce.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
