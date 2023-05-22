package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Usuario;
import com.residencia.biblioteca.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioService;
	
	public List<Usuario> getAllUsuarios(){
		return usuarioService.findAll();
	}
	
	public Usuario getUsuarioById(Integer id) {
		return usuarioService.findById(id).orElse(null);
	}
	
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioService.save(usuario);
	}
	
	public Usuario updateUsuario(Usuario usuario, Integer id) {
		return usuarioService.save(usuario);
	}
	
	public void deleteUsuario(Integer id) {
		usuarioService.deleteById(id);
	}
	
	public Boolean delUsuario(Integer id) {
		usuarioService.deleteById(id);
		Usuario usuarioDeletado = usuarioService.findById(id).orElse(null);
		if(usuarioDeletado == null)
			return true;
		else
			return false;
	}
}
