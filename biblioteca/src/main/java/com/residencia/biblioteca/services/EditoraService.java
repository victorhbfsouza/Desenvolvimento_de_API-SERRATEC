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
	EditoraRepository editoraService;
	
	public List<Editora> getAllEditoras(){
		return editoraService.findAll();
	}
	
	public Editora getEditoraById(Integer id) {
		return editoraService.findById(id).orElse(null);
	}
	
	/*
	//DTO
	public EditoraResumidaDTO getEditoraDTOById(Integer id) {
		//Instancia a editora c/ o método
		Editora editora = editoraService.findById(id).orElse(null);
		//Instancia a editoraDTO
		EditoraResumidaDTO editoraDTO = new EditoraResumidaDTO();
		
		//Se essa condição for verdadeira, para aqui e corrige o NullPointer
		if(editora == null) {
			return null;
		}
		
		//Acessa os valores da editora para atribuir para a editoraDTO
		editoraDTO.setCodigoEditora(editora.getCodigoEditora());
		editoraDTO.setNome(editora.getNome());
		
		//Retorna a editoraDTO c/ as propriedades
		return editoraDTO;
	}
	*/
	
	//DTO - Editora com info dos livros
	//	Precisara percorrer a lista de livros
		public EditoraResumidaDTO getEditoraDTOById(Integer id) {
			Editora editora = editoraService.findById(id).orElse(null);
			EditoraResumidaDTO editoraDTO = new EditoraResumidaDTO();
			
			if(editora == null) {
				return null;
			}
			
			editoraDTO.setCodigoEditora(editora.getCodigoEditora());
			editoraDTO.setNome(editora.getNome());
			
			List<LivroResumidoDTO> listaLivroResDTO = new ArrayList<>();
			
			//A cada interação da coleção de livros - pegara as infos que queremos
			for(Livro livro : editora.getLivro()) {
				LivroResumidoDTO livroResDTO = new LivroResumidoDTO();
				livroResDTO.setNomeLivro(livro.getNomeLivro());
				livroResDTO.setNomeAutor(livro.getNomeAutor());
				livroResDTO.setDataLancamento(livro.getDataLancamento());
				listaLivroResDTO.add(livroResDTO);
			}
			
			editoraDTO.setListaLivroResumido(listaLivroResDTO);
			
			return editoraDTO;
		}
	
	public Editora saveEditora(Editora editora) {
		return editoraService.save(editora);
	}
	
	public Editora updateEditora(Editora editora, Integer id) {
		return editoraService.save(editora);
	}
	
	public void deleteEditora(Integer id) {
		editoraService.deleteById(id);
	}
	
	public Boolean delEditora(Integer id) {
		editoraService.deleteById(id);
		Editora editoraDeletado = editoraService.findById(id).orElse(null);
		if(editoraDeletado == null)
			return true;
		else
			return false;
	}
}
