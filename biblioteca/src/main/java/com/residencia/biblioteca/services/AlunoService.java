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
import com.residencia.biblioteca.enums.StatusDeleteEnum;
import com.residencia.biblioteca.exception.AlunoNotFoundException;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	EmailService emailService;
	
	public List<Aluno> getAllAlunos() {
		return alunoRepository.findAll();
	}
	
	public Aluno getAlunoById(Integer id) {
		//return alunoRepository.findById(id).get();
		
		return alunoRepository.findById(id)
        .orElseThrow(() -> new AlunoNotFoundException(id));
		
		//return alunoRepository.findById(id).orElse(null);
	}
	
	public AlunoResumidoDTO getAlunoEmprestimosDto(Integer id) {
		Aluno aluno = alunoRepository.findById(id).orElse(null);
		if(null == aluno)
			return null;
		
		AlunoResumidoDTO alunoResDto = new AlunoResumidoDTO();
		alunoResDto.setNome(aluno.getNome());
		alunoResDto.setCpf(aluno.getCpf());
		
		List<EmprestimoResumidoDTO> listaEmprestimoResDto = new ArrayList<>();
		for(Emprestimo emprestimo : aluno.getEmprestimos()) {
			EmprestimoResumidoDTO emprestimoResDto = new EmprestimoResumidoDTO();
			emprestimoResDto.setDataEmprestimo(emprestimo.getDataEmprestimo());
			emprestimoResDto.setDataEntrega(emprestimo.getDataEntrega());
			
			LivroResumidoDTO livroResDto = new LivroResumidoDTO();
			
			if(null == emprestimo.getLivro())
				livroResDto.setNomeLivro(null);
			else
				livroResDto.setNomeLivro(emprestimo.getLivro().getNomeLivro());

			emprestimoResDto.setLivroResumidoDto(livroResDto);
			listaEmprestimoResDto.add(emprestimoResDto);
		}
		
		alunoResDto.setListaEmprestimoResDto(listaEmprestimoResDto);
		
		return alunoResDto;
	}
	
	public Aluno saveAluno(Aluno aluno) {
		Aluno novoAluno = alunoRepository.save(aluno);
		emailService.enviarEmail("aopaixao@gmail.com", 
				"Novo Aluno Cadastrado", novoAluno.toString());
		return novoAluno;
	}
	
	public AlunoDTO saveAlunoDto(AlunoDTO alunoDto) {
		/*
		Aluno aluno = new Aluno();
		aluno.setBairro(alunoDto.getBairro());
		aluno.setCidade(alunoDto.getCidade());
		aluno.setComplemento(alunoDto.getComplemento());
		aluno.setCpf(alunoDto.getCpf());
		aluno.setDataNascimento(alunoDto.getDataNascimento());
		aluno.setLogradouro(alunoDto.getLogradouro());
		aluno.setNome(alunoDto.getNome());
		aluno.setNumeroLogradouro(alunoDto.getNumeroLogradouro());
		
		Aluno novoAluno = alunoRepository.save(aluno);
		AlunoDTO novoAlunoDTO = new AlunoDTO();
		
		novoAlunoDTO.setBairro(novoAluno.getBairro());
		novoAlunoDTO.setCidade(novoAluno.getCidade());
		novoAlunoDTO.setComplemento(novoAluno.getComplemento());
		novoAlunoDTO.setCpf(novoAluno.getCpf());
		novoAlunoDTO.setDataNascimento(novoAluno.getDataNascimento());
		novoAlunoDTO.setLogradouro(novoAluno.getLogradouro());
		novoAlunoDTO.setNome(novoAluno.getNome());
		novoAlunoDTO.setNumeroLogradouro(novoAluno.getNumeroLogradouro());
		novoAlunoDTO.setNumeroMatriculaAluno(novoAluno.getNumeroMatriculaAluno());
		
		return novoAlunoDTO;
		*/
		Aluno aluno = modelMapper.map(alunoDto, Aluno.class);
		Aluno novoAluno = alunoRepository.save(aluno);
		return modelMapper.map(novoAluno, AlunoDTO.class);
	}

	//Preciso ter cuidado com os dados da instancia aluno quando for atualizar um aluno
	public Aluno updateAluno(Aluno aluno, Integer id) {
		return alunoRepository.save(aluno);
	}

	public void deleteAluno(Integer id) {
		alunoRepository.deleteById(id);
	}
	
	public StatusDeleteEnum delAluno(Integer id) {
		if(null == alunoRepository.findById(id).orElse(null))
			return StatusDeleteEnum.NAO_ENCONTRADO;
		
		alunoRepository.deleteById(id);
		Aluno alunoDeletado = alunoRepository.findById(id).orElse(null);
		if(null == alunoDeletado)
			return StatusDeleteEnum.DELETADO;
		else
			return StatusDeleteEnum.NAO_DELETADO;
	}
}
