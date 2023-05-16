package com.grupo5.atividade1.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupo5.atividade1.entities.Telefone;
import com.grupo5.atividade1.repositories.TelefoneRepository;

@Service
public class TelefoneService {

		@Autowired
		TelefoneRepository telefoneRepository;
		
		public List <Telefone>getAllTelefones() {
			
			return telefoneRepository.findAll();
		}
		
		public Telefone getTelefoneById(Integer id) {
			
			return telefoneRepository.findById(id).orElse(null);	
		}
		
		public Telefone saveTelefone(Telefone telefone) {
			
			return telefoneRepository.save(telefone);
		}
		
		public Telefone updateTelefone(Telefone telefone, Integer id) {
			
			return telefoneRepository.save(telefone);
		}
		
		public void deleteTelefone(Integer id) {
			
			telefoneRepository.deleteById(id);
		}
		
		public Boolean delTelefone(Integer id) {
			
			telefoneRepository.deleteById(id);
			if(telefoneRepository.findById(id).orElse(null) == null)
				return true;
			else
				return false;
		}

	}

