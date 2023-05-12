package com.residencia.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.biblioteca.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
