package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Usuario;
@Repository
public interface UsuarioRepository  extends CrudRepository<Usuario, String>{

	Usuario  findByLogin(String login);
	

}
