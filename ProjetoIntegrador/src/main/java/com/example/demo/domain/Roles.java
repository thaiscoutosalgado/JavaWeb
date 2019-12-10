package com.example.demo.domain;



import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToMany;


import org.springframework.security.core.GrantedAuthority;

public class Roles implements GrantedAuthority{

	@Id
	private String nomeRole;
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuarios;
	
	
	
	public String getNomeRole() {
		return nomeRole;
	}



	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}



	public List<Usuario> getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nomeRole ;
	}

	
}
