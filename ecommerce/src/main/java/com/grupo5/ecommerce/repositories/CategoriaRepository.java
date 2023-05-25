package com.grupo5.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.ecommerce.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
