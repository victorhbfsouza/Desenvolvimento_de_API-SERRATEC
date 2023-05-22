package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Usuario;
import com.residencia.biblioteca.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository UsuarioRepo;
	
	public List<Usuario> getAllUsuario() {
		return UsuarioRepo.findAll();
	}
	
	public Usuario getUsuarioById(Integer id) {
		return UsuarioRepo.findById(id).orElse(null);
	}
	
	public Usuario saveUsuario(Usuario Usuario) {
		return UsuarioRepo.save(Usuario);
	}
	
	public Usuario updateUsuario(Usuario Usuario, Integer id) {
		return UsuarioRepo.save(Usuario);
	}
	
	public Boolean deleteUsuario(Integer id) {
		UsuarioRepo.deleteById(id);
		Usuario usuarioDeletado = UsuarioRepo.findById(id).orElse(null);
		if(usuarioDeletado == null)
			return true;
		else 
			return false;
	}
}