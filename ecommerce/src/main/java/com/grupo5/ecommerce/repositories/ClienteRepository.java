package com.grupo5.ecommerce.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.ecommerce.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	Optional<Cliente> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
}
