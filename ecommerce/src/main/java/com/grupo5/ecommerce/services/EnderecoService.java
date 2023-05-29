package com.grupo5.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo5.ecommerce.entities.Endereco;
import com.grupo5.ecommerce.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public List<Endereco> getAllEnderecos() {
		List<Endereco> enderecos = enderecoRepository.findAll();
		return enderecos;
	}
	
	public Endereco getEnderecoById(Integer id) {
		Endereco endereco = enderecoRepository.findById(id).orElse(null);
		
		if(endereco==null)
			return null;
		
		return endereco;
	}
	
	public Endereco saveEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public Endereco updateEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	   public Boolean delEndereco(Integer id) {
		  if(enderecoRepository.findById(id).orElse(null)!=null) {
			  enderecoRepository.deleteById(id);
			  if(enderecoRepository.findById(id).orElse(null)==null)
				  return true;
		     else
		    	 return false;
		  }
		    else return false;
	      }
}
