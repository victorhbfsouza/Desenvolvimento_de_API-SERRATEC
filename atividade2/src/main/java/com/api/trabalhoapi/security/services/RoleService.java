package com.api.trabalhoapi.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.trabalhoapi.entities.Role;
import com.api.trabalhoapi.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	public Role save(Role role) {
		return roleRepository.save(role);
	}
}

