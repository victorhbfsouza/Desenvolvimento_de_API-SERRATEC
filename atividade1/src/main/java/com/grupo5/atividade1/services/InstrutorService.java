package com.grupo5.atividade1.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupo5.atividade1.entities.Instrutor;
import com.grupo5.atividade1.repositories.InstrutorRepository;

@Service
public class InstrutorService {

	@Autowired
	InstrutorRepository instrutorRepository;
	
	public List <Instrutor>getAllInstrutores() {
		
		return instrutorRepository.findAll();
	}
	
	public Instrutor getInstrutorById(Integer id) {
		
		return instrutorRepository.findById(id).orElse(null);	
	}
	
	public Instrutor saveInstrutor(Instrutor instrutor) {
		
		return instrutorRepository.save(instrutor);
	}
	
	public Instrutor updateInstrutor(Instrutor instrutor, Integer id) {
		
		return instrutorRepository.save(instrutor);
	}
	
	public void deleteInstrutor(Integer id) {
		
		instrutorRepository.deleteById(id);
	}
	
	public Boolean delInstrutor(Integer id) {
		
		instrutorRepository.deleteById(id);
		if(instrutorRepository.findById(id).orElse(null) == null)
			return true;
		else
			return false;
	}

}
