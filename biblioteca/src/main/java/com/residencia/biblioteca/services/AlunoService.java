package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.dto.AlunoDTO;
import com.residencia.biblioteca.dto.AlunoResumidoDTO;
import com.residencia.biblioteca.dto.EmprestimoResumidoDTO;
import com.residencia.biblioteca.dto.LivroResumidoDTO;
import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.mappers.AlunoMapper;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	AlunoMapper alunoMapper;
	
	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}

	public Aluno getAlunoById(Integer id) {
		return alunoRepository.findById(id).orElse(null);
	}
	
	/*//Eu quem fiz esse, depois ver o do professor
	//DTO - aluno emprestimo
	public AlunoResumidoDTO getAlunoDTOById(Integer id) {
		Aluno aluno = alunoRepository.findById(id).orElse(null);
		AlunoResumidoDTO alunoResDTO = new AlunoResumidoDTO();
		if(aluno == null) {
			return null;
		}
		alunoResDTO.setNome(aluno.getNome());
		alunoResDTO.setCpf(aluno.getCpf());
		List<EmprestimoResumidoDTO> listaEmprestimoDTO = new ArrayList<>();
		for(Emprestimo emprestimo : aluno.getEmprestimos()) {
			EmprestimoResumidoDTO emprestimoResDTO = new EmprestimoResumidoDTO();
			emprestimoResDTO.setDataEmprestimo(emprestimo.getDataEmprestimo());
			emprestimoResDTO.setDataEntrega(emprestimo.getDataEntrega());
			//PAra resumir, mas pode dar NullPointer
			//emprestimoResDTO.setnomeLivro(emprestimo.getLivro().getNomeLivro());
			
			//Emprestimo acessar o livro e pegar o nome
			Livro livro = emprestimo.getLivro();
			if(livro != null) {
				LivroResumidoDTO livroDTO = new LivroResumidoDTO();
				livroDTO.setNomeLivro(livro.getNomeLivro());
				emprestimoResDTO.setnomeLivro(livroDTO.getNomeLivro());
			}
			listaEmprestimoDTO.add(emprestimoResDTO);
		}
		alunoResDTO.listaEmprestimosDTO(listaEmprestimoDTO);
		return alunoResDTO;
	}
	*/
	
	//DTO - aluno emprestimo - Professor
	public AlunoResumidoDTO getAlunoEmprestimosDTO(Integer id) {
		Aluno aluno = alunoRepository.findById(id).orElse(null);
		AlunoResumidoDTO alunoResDTO = new AlunoResumidoDTO();
		if(aluno == null) {
			return null;
		}
		alunoResDTO.setNome(aluno.getNome());
		alunoResDTO.setCpf(aluno.getCpf());
		List<EmprestimoResumidoDTO> listaEmprestimoDTO = new ArrayList<>();
		for(Emprestimo emprestimo : aluno.getEmprestimos()) {
			EmprestimoResumidoDTO emprestimoResDTO = new EmprestimoResumidoDTO();
			emprestimoResDTO.setDataEmprestimo(emprestimo.getDataEmprestimo());
			emprestimoResDTO.setDataEntrega(emprestimo.getDataEntrega());
			/*	
			LivroResumidoDTO livroDTO = new LivroResumidoDTO();
			livroDTO.setNomeLivro(emprestimo.getLivro().getNomeLivro());
				
			if(emprestimo.getLivro() == null)
				livroDTO.setNomeLivro(null);
			else
				emprestimoResDTO.setNomeLivro(livroDTO.getNomeLivro());
			*/
			LivroResumidoDTO livroDTO = new LivroResumidoDTO(emprestimo.getLivro().getNomeLivro());
				
			if(emprestimo.getLivro() == null)
				livroDTO.setNomeLivro(null);
			else
				emprestimoResDTO.setNomeLivro(livroDTO.getNomeLivro());
			
			listaEmprestimoDTO.add(emprestimoResDTO);
		}
		alunoResDTO.setlistaEmprestimosDTO(listaEmprestimoDTO);
		return alunoResDTO;
	}
	
	public Aluno saveAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	/*
	//Eu quem fiz
	public AlunoDTO saveAlunoDTO(AlunoDTO alunoDTO) {
		Aluno aluno = new Aluno();
		aluno.setNome(alunoDTO.getNome());
		aluno.setDataNascimento(alunoDTO.getDataNascimento());
		aluno.setCpf(alunoDTO.getCpf());
		aluno.setLogradouro(alunoDTO.getLogradouro());
		aluno.setNumeroLogradouro(alunoDTO.getNumeroLogradouro());
		aluno.setComplemento(alunoDTO.getComplemento());
		aluno.setBairro(alunoDTO.getBairro());
		aluno.setCidade(alunoDTO.getCidade());
		alunoRepository.save(aluno);
		
		Aluno novoAluno = alunoRepository.save(aluno);
		
		AlunoDTO novoAlunoDTO = new AlunoDTO();
		
		novoAlunoDTO.setNumeroMatriculaAluno(novoAluno.getNumeroMatriculaAluno());
		novoAlunoDTO.setNome(novoAluno.getNome());
		novoAlunoDTO.setDataNascimento(novoAluno.getDataNascimento());
		novoAlunoDTO.setCpf(novoAluno.getCpf());
		novoAlunoDTO.setLogradouro(novoAluno.getLogradouro());
		novoAlunoDTO.setNumeroLogradouro(novoAluno.getNumeroLogradouro());
		novoAlunoDTO.setComplemento(novoAluno.getComplemento());
		novoAlunoDTO.setBairro(novoAluno.getBairro());
		novoAlunoDTO.setCidade(novoAluno.getCidade());
		
		return novoAlunoDTO;
	}
	*/
	
	public AlunoDTO saveAlunoDTO(AlunoDTO alunoDTO) {
		
		Aluno novoAluno = alunoRepository.save(alunoMapper.toEntity(alunoDTO));
		AlunoDTO novoAlunoDTO = alunoMapper.toDto(novoAluno);
		
		/*
		//Indo por Mapper - precisa da dependencia
		ModelMapper modelMapper = new ModelMapper();
		Aluno alunoMapper = modelMapper.map(alunoDTO, Aluno.class);
		AlunoDTO alunoDTOMapper = modelMapper.map(alunoMapper, AlunoDTO.class);
		return alunoDTOMapper;
		*/
		
		return novoAlunoDTO;
	}
	
	public Aluno updateAluno(Aluno aluno, Integer id) {
		return alunoRepository.save(aluno);
	}
	
	public void deleteAluno(Integer id) {
		alunoRepository.deleteById(id);
	}
	
	public Boolean delAluno(Integer id) {
		alunoRepository.deleteById(id);
		Aluno alunoDeletado = alunoRepository.findById(id).orElse(null);
		if(alunoDeletado == null)
			return true;
		else
			return false;
	}
}
