package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroService;
	
	public List<Livro> getAllLivros(){
		return livroService.findAll();
	}
	
	public Livro getLivroById(Integer id) {
		return livroService.findById(id).orElse(null);
	}
	
	public Livro saveLivro(Livro livro) {
		return livroService.save(livro);
	}
	
	public Livro updateLivro(Livro livro, Integer id) {
		return livroService.save(livro);
	}
	
	public void deleteLivro(Integer id) {
		livroService.deleteById(id);
	}
	
	public Boolean delLivro(Integer id) {
		livroService.deleteById(id);
		Livro livroDeletado = livroService.findById(id).orElse(null);
		if(livroDeletado == null)
			return true;
		else
			return false;
	}
}
