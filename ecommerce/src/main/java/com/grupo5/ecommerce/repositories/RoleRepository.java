package com.grupo5.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo5.ecommerce.entities.Role;
import com.grupo5.ecommerce.entities.RoleEnum;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role>findByName(RoleEnum name);
	
}
