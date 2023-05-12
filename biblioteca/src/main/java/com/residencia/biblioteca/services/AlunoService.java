package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();		
	}
	
	public Aluno getAlunoById(Integer id) {
		return alunoRepository.findById(id).orElse(null);
	}
	
	public Aluno saveAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	//update aluno set nome = "Alexandre" where numeromatriculaaluno = 10;
	//Preciso ter cuidado com os dados da instancia aluno quando for atualizar um aluno
	public Aluno updateAluno(Aluno aluno, Integer id) {
		return alunoRepository.save(aluno);
	}
	
	//delete from aluno where numeromatriculaaluno = 10;
	public void deleteAluno(Integer id) {
		alunoRepository.deleteById(id);
	}
	
	public Boolean delAluno(Integer id) {
		alunoRepository.deleteById(id);
		return alunoDeletado = alunoRepository.findById(id).orElse(null);
		if (null == alunoDeletado)
			return true;
			else 
				return false;
	}
}
