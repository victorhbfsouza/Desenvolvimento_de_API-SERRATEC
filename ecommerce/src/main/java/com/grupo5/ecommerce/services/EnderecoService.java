package com.grupo5.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.grupo5.ecommerce.entities.Endereco;
import com.grupo5.ecommerce.repositories.EnderecoRepository;

public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	public List<Endereco> getAllEnderecos() {
		return enderecoRepository.findAll();
	}
	
	public Endereco getEnderecoById(Integer id) {
		return enderecoRepository.findById(id).orElse(null);
	}
	
	public Endereco saveEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	
	public Endereco updateEndereco(Endereco endereco, Integer id) {
		return enderecoRepository.save(endereco);
	}
	
	public void deleteEndereco(Integer id) {
		enderecoRepository.deleteById(id);
	}
	
	public Boolean delEndereco(Integer id) {
		enderecoRepository.deleteById(id);
		Endereco enderecoDeletado = enderecoRepository.findById(id).orElse(null);
		if (null == enderecoDeletado) {
			return true;
		}else {
			return false;
		}
	}
}


