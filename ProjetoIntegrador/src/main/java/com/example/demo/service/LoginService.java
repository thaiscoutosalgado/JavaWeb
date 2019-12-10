package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Aluno;
import com.example.demo.repository.AlunoRepositoty;

@Service
public class LoginService {

	@Autowired
	private AlunoRepositoty alunoCat;

	public boolean login(Aluno aluno) {
		Aluno alunoEncontrado = alunoCat.findByEmailAndNome(aluno.getEmail(), aluno.getNome());
		if (alunoEncontrado == null)
			return false;
		return true;
	}
}
