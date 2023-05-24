package com.grupo5.atividade1.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grupo5.atividade1.entities.Telefone;
import com.grupo5.atividade1.repositories.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired //Serve para instanciar outra classe
	TelefoneRepository telefoneRepository;
	
	
	public List<Telefone> getAllTelefones() {
		return telefoneRepository.findAll();
	}
	
	public Telefone getTelefoneById(Integer id) {
		return telefoneRepository.findById(id).orElse(null);
	}
	
	public Telefone saveTelefone(Telefone telefone) {
		Boolean verificaInstrutor = true;
		List<Telefone> listaTelefone = this.getAllTelefones();
		for (Telefone t : listaTelefone) {
			if(t.getInstrutor().getId() == telefone.getInstrutor().getId()) {
				verificaInstrutor = false;
			}
		}
		if (verificaInstrutor) {
			return telefoneRepository.save(telefone);
		}else {
			return null;
		}
	}
	
	
	//Preciso ter cuidado com os dados da instancia telefone quando for atualizar um telefone
	public Telefone updateTelefone(Telefone telefone, Integer id) {
		return telefoneRepository.save(telefone);
	}
	
	public void deleteTelefone(Integer id) {
		telefoneRepository.deleteById(id);
	}
	
	public Boolean delTelefone(Integer id) {
		telefoneRepository.deleteById(id);
		Telefone telefoneDeletado = telefoneRepository.findById(id).orElse(null);
		if (null == telefoneDeletado) {
			return true;
		}else {
			return false;
		}
	}
}
