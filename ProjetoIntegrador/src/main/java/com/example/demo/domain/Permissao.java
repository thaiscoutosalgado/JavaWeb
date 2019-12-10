package com.example.demo.domain;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

public class Permissao  implements GrantedAuthority{

	@Id
	private String nomePermissao;
	
	@ManyToMany(mappedBy = "permissao")
	private List<Usuario> usuario;
	
	
	
	
	public String getNomePermissao() {
		return nomePermissao;
	}




	public void setNomePermissao(String nomePermissao) {
		this.nomePermissao = nomePermissao;
	}




	public List<Usuario> getUsuario() {
		return usuario;
	}




	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}




	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

}
