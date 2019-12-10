package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.domain.Usuario;
import com.example.demo.repository.UsuarioRepository;

public class CurrentUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository ur;
	
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = ur.findByLogin(login);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
			
		}
		
		return new User(usuario.getUsername(),usuario.getPassword(),true, true, true, true, usuario.getAuthorities());
	}

}
