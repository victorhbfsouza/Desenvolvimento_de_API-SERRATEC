package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.dto.AlunoResumidoDTO;
import com.residencia.biblioteca.dto.EmprestimoResumidoDTO;
import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public List <Aluno>getAllAlunos() {
		
		return alunoRepository.findAll();
	}
	
	public Aluno getAlunoById(Integer id) {
		
		return alunoRepository.findById(id).orElse(null);	
	}
	public AlunoResumidoDTO getAlunoResumidoDTOById(Integer id) {
		
		Aluno aluno =  alunoRepository.findById(id).orElse(null);
		if(null == aluno)
			return null;
		List<EmprestimoResumidoDTO> listaEmprestimosResDTO = new ArrayList<>();
		for(Emprestimo emprestimo : aluno.getEmprestimos()) {
			EmprestimoResumidoDTO emprestimoResumidoDTO = new EmprestimoResumidoDTO();
			emprestimoResumidoDTO.setDataEmprestimo(emprestimo.getDataEmprestimo());
			emprestimoResumidoDTO.setDataEntrega(emprestimo.getDataEntrega());
			emprestimoResumidoDTO.setNomeLivro(emprestimo.getLivro().getNomeLivro());
			listaEmprestimosResDTO.add(emprestimoResumidoDTO);
		}
		AlunoResumidoDTO alunoResumidoDTO = new AlunoResumidoDTO();
		alunoResumidoDTO.setNome(aluno.getNome());
		alunoResumidoDTO.setCpf(aluno.getCpf());
		alunoResumidoDTO.setListaEmprestimosResDTO(listaEmprestimosResDTO);
		
		return alunoResumidoDTO;
	}
	
	public Aluno saveAluno(Aluno aluno) {
		
		return alunoRepository.save(aluno);
	}
	
	public Aluno updateAluno(Aluno aluno, Integer id) {
		
		return alunoRepository.save(aluno);
	}
	
	public void deleteAluno(Integer id) {
		
		alunoRepository.deleteById(id);
	}
	
	public Boolean delAluno(Integer id) {
		
		alunoRepository.deleteById(id);
		if(alunoRepository.findById(id).orElse(null) == null)
			return true;
		else
			return false;
	}

}
