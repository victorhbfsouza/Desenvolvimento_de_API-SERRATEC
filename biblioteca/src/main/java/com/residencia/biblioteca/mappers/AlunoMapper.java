package com.residencia.biblioteca.mappers;

import org.springframework.stereotype.Component;

import com.residencia.biblioteca.dto.AlunoDTO;
import com.residencia.biblioteca.entities.Aluno;

//Precisa estar aqui para fazer o Autowired
@Component
public class AlunoMapper {
	
	public Aluno toEntity(AlunoDTO alunoDTO) {
		
		Aluno aluno = new Aluno();
		
		aluno.setNome(alunoDTO.getNome());
		aluno.setDataNascimento(alunoDTO.getDataNascimento());
		aluno.setCpf(alunoDTO.getCpf());
		aluno.setLogradouro(alunoDTO.getLogradouro());
		aluno.setNumeroLogradouro(alunoDTO.getNumeroLogradouro());
		aluno.setComplemento(alunoDTO.getComplemento());
		aluno.setBairro(alunoDTO.getBairro());
		aluno.setCidade(alunoDTO.getCidade());
		
		return aluno;
	}
	
	public AlunoDTO toDto(Aluno novoAluno) {
		
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
}
