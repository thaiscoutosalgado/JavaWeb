package com.example.demo.init;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Permissao;
import com.example.demo.domain.Roles;
import com.example.demo.domain.Usuario;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.permissaoRepository;


@Component
public class Init  implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	UsuarioRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	permissaoRepository repoPermissao;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Usuario usuario = new Usuario();
		usuario.setLogin("admim");
		usuario.setNomeCompleto("Thais");
		usuario.setSenha(new BCryptPasswordEncoder().encode("123"));
		
		userRepository.save(usuario);
		
		Roles roleAdmin = new Roles();
		roleAdmin.setNomeRole("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
	
		usuario.setRoles(Arrays.asList(roleAdmin));
		
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("estruc");
		usuario2.setNomeCompleto("Marcelo");
		usuario2.setSenha(new BCryptPasswordEncoder().encode("1234"));
		
		Roles roleUser = new Roles();
		roleUser.setNomeRole("ROLE_USER");
		
		Permissao permissaoUser = new Permissao();
		permissaoUser.setNomePermissao("insert");
		
		repoPermissao.save(permissaoUser);
		
		roleRepository.save(roleUser);
		usuario2.setRoles(Arrays.asList(roleUser));
		
		usuario2.setPermissoes(Arrays.asList(permissaoUser));
		
		userRepository.save(usuario2);
		
		
		Usuario usuario3 = new Usuario();
		usuario3.setLogin("salvato");
		usuario3.setNomeCompleto("Sara");
		usuario3.setSenha(new BCryptPasswordEncoder().encode("12345"));
		
		usuario3.setRoles(Arrays.asList(roleAdmin,roleUser));
		userRepository.save(usuario3);
	
	}
	

}
