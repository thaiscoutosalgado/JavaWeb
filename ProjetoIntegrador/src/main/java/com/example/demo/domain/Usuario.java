package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
public class Usuario implements UserDetails, Serializable{

	
	
	private static final long serialVersionUID = 8195491500834579417L;
	@Id
	private String login;
	private String nomeCompleto;
	private String senha;
	
	@ManyToMany
	@JoinTable(
	name = "usuarios_roles",
	joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "login"),
	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "nomeRole"))
	private List<Role> roles;
	
	
	@ManyToMany
	@JoinTable(
	name = "usuarios_permissoes",
	joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "login"),
	inverseJoinColumns = @JoinColumn(name = "permissao_id", referencedColumnName = "nomePermissao"))
	private List<Permissao> permissoes;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList();
		
		this.permissoes.forEach(p ->{
			GrantedAuthority authority = new SimpleGrantedAuthority(p.getNomePermissao());
		});
		
		this.roles.forEach(r->{
			GrantedAuthority authority = new SimpleGrantedAuthority(r.getRoleName());
		});
		
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public void setRoles(List<Roles> asList) {
		// TODO Auto-generated method stub
		
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setPermissoes(List<Permissao> asList) {
		// TODO Auto-generated method stub
		
	}
	public List<Permissao> getPermissoes() {
		return permissoes;
	}
	
	
	
	
	
}
