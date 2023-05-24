package com.api.trabalhoapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.trabalhoapi.entities.Role;
import com.api.trabalhoapi.entities.RoleEnum;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(RoleEnum name);
}
