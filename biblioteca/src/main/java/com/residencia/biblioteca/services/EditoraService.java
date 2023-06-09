package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.residencia.biblioteca.dto.EditoraResumidaDTO;
import com.residencia.biblioteca.dto.LivroResumidoDTO;
import com.residencia.biblioteca.dto.ReceitaWsDTO;
import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {
	
	@Autowired
	EditoraRepository editoraRepository;
	
	public List <Editora>getAllEditoras() {
		
		return editoraRepository.findAll();
	}
	
	public Editora getEditoraById(Integer id) {
		
		return editoraRepository.findById(id).orElse(null);	
	}
	
	public EditoraResumidaDTO getEditoraDtoById(Integer id) {		
		
		Editora editora = editoraRepository.findById(id).orElse(null);
		
		if(null == editora)
			return null;
		
		List<LivroResumidoDTO> listaLivroResDTO = new ArrayList<>();
		for(Livro livro : editora.getLivros()) {
			LivroResumidoDTO livroResDTO = new LivroResumidoDTO();
			livroResDTO.setNomeLivro(livro.getNomeLivro());
			livroResDTO.setNomeAutor(livro.getNomeAutor());
			livroResDTO.setDataLancamento(livro.getDataLancamento());
			listaLivroResDTO.add(livroResDTO);
			
		}
		
		EditoraResumidaDTO editoraResumidaDTO = new EditoraResumidaDTO(editora, listaLivroResDTO);		
		return editoraResumidaDTO;
		
		
	}
	
	public Editora saveEditora(Editora editora) {
		
		ReceitaWsDTO recDto = consultaApiReceitaWs(editora.getCnpj());
		System.out.println("ReceitaWdTTO: " + recDto);
		
		return editoraRepository.save(editora);
	}
	
	public Editora updateEditora(Editora editora, Integer id) {
		
		return editoraRepository.save(editora);
	}
	
	public void deleteEditora(Integer id) {
		
		editoraRepository.deleteById(id);
	}
	
	public Boolean delEditora(Integer id) {
		
		editoraRepository.deleteById(id);
		if(editoraRepository.findById(id).orElse(null) == null)
			return true;
		else
			return false;
	}
	
	private ReceitaWsDTO consultaApiReceitaWs(String cnpj) {
		
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://receitaws.com.br/v1/cnpj/{cnpj}";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("cnpj", cnpj);
		
		ReceitaWsDTO recDto = restTemplate.getForObject(uri, ReceitaWsDTO.class, params);		
		return recDto;
	}

}
