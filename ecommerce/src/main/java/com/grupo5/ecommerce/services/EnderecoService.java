package com.grupo5.ecommerce.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.grupo5.ecommerce.dto.ViaCepDTO;
import com.grupo5.ecommerce.entities.Endereco;
import com.grupo5.ecommerce.exceptions.EnderecoNotFoundException;
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
		Endereco endereco = enderecoRepository.findById(id).orElseThrow(()
				-> new EnderecoNotFoundException(id));

		if (endereco == null)
			return null;

		return endereco;
	}

	public Endereco saveEndereco(Endereco endereco) {
		
		ViaCepDTO cepDto = consultaApi(endereco.getCep());
		System.out.println("ViaCepDTO: " + cepDto.toString());
		
		endereco.setBairro(cepDto.getBairro());
		endereco.setCep(cepDto.getCep());
		endereco.setCidade(cepDto.getLocalidade());
		endereco.setRua(cepDto.getLogradouro());
		endereco.setUf(cepDto.getUf());
		
		return enderecoRepository.save(endereco);
	}

	public Endereco updateEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Boolean delEndereco(Integer id) {
		if (enderecoRepository.findById(id).orElse(null) != null) {
			enderecoRepository.deleteById(id);
			if (enderecoRepository.findById(id).orElse(null) == null)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	private ViaCepDTO consultaApi(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://viacep.com.br/ws/{cep}/json/";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", cep);
		
		ViaCepDTO cepDto = restTemplate.getForObject(uri, ViaCepDTO.class, params);
		
		return cepDto;
	}
}
