package com.grupo5.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.ecommerce.entities.Categoria;
import com.grupo5.ecommerce.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAllCategorias() {
		List<Categoria> categorias = categoriaRepository.findAll();
		return categorias;
	}
	
	public Categoria getCategoriaById(Integer id) {
		Categoria categoria = categoriaRepository.findById(id).orElse(null);
		
		if(categoria==null)
			return null;
		
		return categoria;
	}
	
	public Categoria saveCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public Categoria updateCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	   public Boolean delCategoria(Integer id) {
		  if(categoriaRepository.findById(id).orElse(null)!=null) {
			  categoriaRepository.deleteById(id);
			  if(categoriaRepository.findById(id).orElse(null)==null)
				  return true;
		     else
		    	 return false;
		  }
		    else return false;
	      }
}
