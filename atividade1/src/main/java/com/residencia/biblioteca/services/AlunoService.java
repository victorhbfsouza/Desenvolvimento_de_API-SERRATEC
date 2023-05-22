package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.dto.AlunoDTO;
import com.residencia.biblioteca.dto.AlunoResumidoDTO;
import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;
	
	//métodos de regra de negócio e CRUD
	
	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}
	
	public Aluno getAlunoById(Integer id) {
		return alunoRepository.findById(id).orElse(null);
	}
	
	public AlunoResumidoDTO getAlunoDTOById(Integer id) {
		Aluno aluno = alunoRepository.findById(id).orElse(null);
		
		if(aluno == null) 
			return null;
		
		AlunoResumidoDTO alunoDTO = new AlunoResumidoDTO();
		
		alunoDTO.setNome(aluno.getNome());
		alunoDTO.setCpf(aluno.getCpf());
		List<String> listaLivrosEmprestados = new ArrayList<>();
		
		for(Emprestimo e : aluno.getListaEmprestimo()) {
			listaLivrosEmprestados.add(e.getLivro().getNomeLivro());
		}
		
		alunoDTO.setLivroEmprestado(listaLivrosEmprestados);
		
		return alunoDTO;
	}
	
	public Aluno saveAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
//	public AlunoDTO saveAlunoDTO(AlunoDTO alunoDTO) {
//		
//		Aluno aluno = new modelMapper.map(alunoDTO, Aluno.class);
//		
//		
//		alunoRepository.save(aluno);
//		
//		return alunoDTO;
//	}
	
	//pode ser feito com o Aluno aluno também
	public Boolean deleteAluno(Integer id) {
		alunoRepository.deleteById(id);
		Aluno alunoDeletado = alunoRepository.findById(id).orElse(null);
		if (alunoDeletado == null) 
			return true;
		else
			return false;
	}
	
	public Aluno updateAluno(Aluno aluno, Integer id) {
		return alunoRepository.save(aluno);
	}

} 
