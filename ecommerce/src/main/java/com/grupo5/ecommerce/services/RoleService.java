package com.grupo5.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.ecommerce.entities.Role;
import com.grupo5.ecommerce.repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	public List<Role> getAllRoles() {
		List<Role> roles = roleRepository.findAll();
		return roles;
	}
	
	public Role getRoleById(Integer id) {
		Role role = roleRepository.findById(id).orElse(null);
		
		if(role==null)
			return null;
		
		return role;
	}
	
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}
	
	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}
	
	   public Boolean delRole(Integer id) {
		  if(roleRepository.findById(id).orElse(null)!=null) {
			  roleRepository.deleteById(id);
			  if(roleRepository.findById(id).orElse(null)==null)
				  return true;
		     else
		    	 return false;
		  }
		    else return false;
	    	  
	      }
}
