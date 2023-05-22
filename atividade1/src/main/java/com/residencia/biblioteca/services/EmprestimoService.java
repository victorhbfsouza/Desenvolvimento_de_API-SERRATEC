package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.dto.EmprestimoResumidoDTO;
import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	EmprestimoRepository emprestimoRepo;
	
	public List<Emprestimo> getAllEmprestimo() {
		return emprestimoRepo.findAll();
	}
	
	public Emprestimo getEmprestimoById(Integer id) {
		return emprestimoRepo.findById(id).orElse(null);
	}
	
	public EmprestimoResumidoDTO getEmprestimoDTOById(Integer id) {
		Emprestimo emprestimo = emprestimoRepo.findById(id).orElse(null);
		
		if(emprestimo == null)
			return null;
		
		EmprestimoResumidoDTO emprestimoDTO = new EmprestimoResumidoDTO();
		
		emprestimoDTO.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoDTO.setDataEntrega(emprestimo.getDataEntrega());
		
		//para evitar null pointer
		Livro livro = emprestimo.getLivro();
		
		String nomeLivro  = "";
		
		if(livro != null)
			nomeLivro = livro.getNomeLivro(); 
		
		emprestimoDTO.setNomeLivro(nomeLivro);
		
		return emprestimoDTO;
	}
	
	public Emprestimo saveEmprestimo(Emprestimo emprestimo) {
		return emprestimoRepo.save(emprestimo);
	}
	
	public Emprestimo updateEmprestimo(Emprestimo emprestimo, Integer id) {
		return emprestimoRepo.save(emprestimo);
	}
	
	public Boolean deleteEmprestimo(Integer id) {
		emprestimoRepo.deleteById(id);
		Emprestimo emprestimoDeletado = emprestimoRepo.findById(id).orElse(null);
		if(emprestimoDeletado == null)
			return true;
		else 
			return false;
	}
}
