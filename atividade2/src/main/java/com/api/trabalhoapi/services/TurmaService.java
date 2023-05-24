package com.api.trabalhoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.trabalhoapi.entities.Turma;
import com.api.trabalhoapi.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired //Serve para instanciar outra classe
	TurmaRepository turmaRepository;
	
	public List<Turma> getAllTurmas() {
		return turmaRepository.findAll();
	}
	
	public Turma getTurmaById(Integer id) {
		return turmaRepository.findById(id).orElse(null);
	}
	
	public Turma saveTurma(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	
	//Preciso ter cuidado com os dados da instancia turma quando for atualizar um turma
	public Turma updateTurma(Turma turma, Integer id) {
		return turmaRepository.save(turma);
	}
	
	public void deleteTurma(Integer id) {
		turmaRepository.deleteById(id);
	}
	
	public Boolean delTurma(Integer id) {
		turmaRepository.deleteById(id);
		Turma turmaDeletado = turmaRepository.findById(id).orElse(null);
		if (null == turmaDeletado) {
			return true;
		}else {
			return false;
		}
	}
}

