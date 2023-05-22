package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository LivroRepo;
	
	public List<Livro> getAllLivro() {
		return LivroRepo.findAll();
	}
	
	public Livro getLivroById(Integer id) {
		return LivroRepo.findById(id).orElse(null);
	}
	
	public Livro saveLivro(Livro Livro) {
		return LivroRepo.save(Livro);
	}
	
	public Livro updateLivro(Livro Livro, Integer id) {
		return LivroRepo.save(Livro);
	}
	
	public Boolean deleteLivro(Integer id) {
		LivroRepo.deleteById(id);
		Livro livroDeletado = LivroRepo.findById(id).orElse(null);
		if(livroDeletado == null)
			return true;
		else 
			return false;
	}
}
