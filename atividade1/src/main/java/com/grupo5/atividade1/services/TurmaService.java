package com.grupo5.atividade1.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupo5.atividade1.entities.Turma;
import com.grupo5.atividade1.repositories.TurmaRepository;

@Service
public class TurmaService {

		@Autowired
		TurmaRepository turmaRepository;
		
		public List <Turma>getAllTurmas() {
			
			return turmaRepository.findAll();
		}
		
		public Turma getTurmaById(Integer id) {
			
			return turmaRepository.findById(id).orElse(null);	
		}
		
		public Turma saveTurma(Turma turma) {
			
			return turmaRepository.save(turma);
		}
		
		public Turma updateTurma(Turma turma, Integer id) {
			
			return turmaRepository.save(turma);
		}
		
		public void deleteTurma(Integer id) {
			
			turmaRepository.deleteById(id);
		}
		
		public Boolean delTelefone(Integer id) {
			
			turmaRepository.deleteById(id);
			if(turmaRepository.findById(id).orElse(null) == null)
				return true;
			else
				return false;
		}

	}


