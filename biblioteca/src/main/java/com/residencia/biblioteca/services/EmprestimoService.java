package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	EmprestimoRepository emprestimoService;
	
	public List<Emprestimo> getAllEmprestimos(){
		return emprestimoService.findAll();
	}
	
	public Emprestimo getEmprestimoById(Integer id) {
		return emprestimoService.findById(id).orElse(null);
	}
	
	public Emprestimo saveEmprestimo(Emprestimo emprestimo) {
		return emprestimoService.save(emprestimo);
	}
	
	public Emprestimo updateEmprestimo(Emprestimo emprestimo, Integer id) {
		return emprestimoService.save(emprestimo);
	}
	
	public void deleteEmprestimo(Integer id) {
		emprestimoService.deleteById(id);
	}
	
	public Boolean delEmprestimo(Integer id) {
		emprestimoService.deleteById(id);
		Emprestimo emprestimoDeletado = emprestimoService.findById(id).orElse(null);
		if(emprestimoDeletado == null)
			return true;
		else
			return false;
	}
}
