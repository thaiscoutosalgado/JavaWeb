package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Permissao;

public interface permissaoRepository  extends CrudRepository<Permissao, String>{

}
