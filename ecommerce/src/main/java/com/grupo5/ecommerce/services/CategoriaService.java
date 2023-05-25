package com.grupo5.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.grupo5.ecommerce.entities.Categoria;
import com.grupo5.ecommerce.repositories.CategoriaRepository;

public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAllCategorias() {
		return categoriaRepository.findAll();
	}
	
	public Categoria getCategoriaById(Integer id) {
		return categoriaRepository.findById(id).orElse(null);
	}
	
	public Categoria saveCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	
	public Categoria updateCategoria(Categoria categoria, Integer id) {
		return categoriaRepository.save(categoria);
	}
	
	public void deleteCategoria(Integer id) {
		categoriaRepository.deleteById(id);
	}
	
	public Boolean delCategoria(Integer id) {
		categoriaRepository.deleteById(id);
		Categoria categoriaDeletado = categoriaRepository.findById(id).orElse(null);
		if (null == categoriaDeletado) {
			return true;
		}else {
			return false;
		}
	}
}

