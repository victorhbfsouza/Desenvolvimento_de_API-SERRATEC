package com.grupo5.atividade1.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupo5.atividade1.entities.Instrutor;
import com.grupo5.atividade1.repositories.InstrutorRepository;


@Service
public class InstrutorService {
	
	@Autowired //Serve para instanciar outra classe
	InstrutorRepository instrutorRepository;
	
	public List<Instrutor> getAllInstrutores() {
		return instrutorRepository.findAll();
	}
	
	public Instrutor getInstrutorById(Integer id) {
		return instrutorRepository.findById(id).orElse(null);
	}
	
	public Instrutor saveInstrutor(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}
	
	
	//Preciso ter cuidado com os dados da instancia instrutor quando for atualizar um instrutor
	public Instrutor updateInstrutor(Instrutor instrutor, Integer id) {
		return instrutorRepository.save(instrutor);
	}
	
	public void deleteInstrutor(Integer id) {
		instrutorRepository.deleteById(id);
	}
	
	public Boolean delInstrutor(Integer id) {
		instrutorRepository.deleteById(id);
		Instrutor instrutorDeletado = instrutorRepository.findById(id).orElse(null);
		if (null == instrutorDeletado) {
			return true;
		}else {
			return false;
		}
	}
}
