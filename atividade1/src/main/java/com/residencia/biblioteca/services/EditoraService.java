package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.dto.EditoraResumidaDTO;
import com.residencia.biblioteca.dto.LivroResumidoDTO;
import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {
	
	@Autowired
	EditoraRepository editoraRepository;
	
	public List<Editora> getAllEditora() {
		return editoraRepository.findAll();
	}
	
	public Editora getEditoraById(Integer id) {
		return editoraRepository.findById(id).orElse(null);
	}
	
	public EditoraResumidaDTO getEditoraDTOById(Integer id) {
		Editora editora = editoraRepository.findById(id).orElse(null);
		
		EditoraResumidaDTO editoraResumidaDTO = new EditoraResumidaDTO();
		
		if(editora == null)
			return null;
		
		editoraResumidaDTO.setCodigoEditora(editora.getCodigoEditora());
		editoraResumidaDTO.setNome(editora.getNome());
		
		List<LivroResumidoDTO> listaLivroDTO = new ArrayList<>();
		
		for(Livro l : editora.getListaLivro()) {
			LivroResumidoDTO livroResumidoDTO = new LivroResumidoDTO();
			livroResumidoDTO.setNomeLivro(l.getNomeLivro());
			livroResumidoDTO.setNomeAutor(l.getNomeAutor());
			livroResumidoDTO.setDataLancamento(l.getDataLancamento());
			listaLivroDTO.add(livroResumidoDTO);
		}
		
		editoraResumidaDTO.setListaLivros(listaLivroDTO);
		
		return editoraResumidaDTO;
	}
	
	public Editora saveEditora(Editora editora) {
		return editoraRepository.save(editora);
	}
	
	public Editora updateEditora(Editora editora, Integer id) {
		return editoraRepository.save(editora);
	}
	
	public Boolean deleteEditora(Integer id) {
		editoraRepository.deleteById(id);
		Editora editoraDeletada = editoraRepository.findById(id).orElse(null);
		if(editoraDeletada == null)
			return true;
		else 
			return false;
	}
}
