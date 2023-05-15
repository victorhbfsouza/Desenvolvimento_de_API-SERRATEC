package com.residencia.biblioteca.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.residencia.biblioteca.entities.Usuario;
import com.residencia.biblioteca.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List <Usuario>getAllUsuarios() {
		
		return usuarioRepository.findAll();
	}
	
	public Usuario getUsuarioById(Integer id) {
		
		return usuarioRepository.findById(id).orElse(null);	
	}
	
	public Usuario saveUsuario(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}
	
	public Usuario updateUsuario(Usuario usuario, Integer id) {
		
		return usuarioRepository.save(usuario);
	}
	
	public void deleteUsuario(Integer id) {
		
		usuarioRepository.deleteById(id);
	}
	
	public Boolean delUsuario(Integer id) {
		
		usuarioRepository.deleteById(id);
		if(usuarioRepository.findById(id).orElse(null) == null)
			return true;
		else
			return false;
	}

}
