package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	public List<Livro> getAllLivros() {
		return livroRepository.findAll();		
	}
	
	public Livro getLivroById(Integer id) {
		return livroRepository.findById(id).orElse(null);
	}
	
	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public Livro updateLivro(Livro livro, Integer id) {
		return livroRepository.save(livro);
	}
	
	public void deleteLivro(Integer id) {
		livroRepository.deleteById(id);
	}
	
	public Boolean delLivro(Integer id) {
		livroRepository.deleteById(id);
		return livroDeletado = livroRepository.findById(id).orElse(null);
		if (null == livroDeletado)
			return true;
			else 
				return false;
	}
}