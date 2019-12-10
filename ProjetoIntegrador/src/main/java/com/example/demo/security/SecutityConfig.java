package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;

public class SecutityConfig  extends WebSecurityConfigurerAdapter{

	
	
	private static String[] PUBLIC_MATCHERS = {"h2=console/**","/curso/index"};
	private static String[] PUBLIC_MATCHERS_GET = {"/categoria/**"};
	
	@Autowired
	private CurrentUserDetailsService userDetailsService;
	
	protected void configure (HttpSecurity http) throws Exception{
		
	http.authorizeRequests().antMatchers(HttpMethod.GET,PUBLIC_MATCHERS_GET).permitAll()
	.antMatchers(PUBLIC_MATCHERS).permitAll()
	.antMatchers(PUBLIC_MATCHERS).hasRole("ADMIN")
	.antMatchers("/curso/fromInserirCurso").permitAll()
	.antMatchers("/curso/formInserirCurso").hasRole("USER")
	.antMatchers("/curso/formInserirCurso").hasAnyAuthority("insert")
	.anyRequest().authenticated()
	.and().formLogin().
	loginProcessingUrl("/signin")
	.loginPage("/login").permitAll()
	.usernameParameter("textUsername")
	.passwordParameter("textPassword")
	.permitAll()
	.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
		
	}
	
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**","/js/**");
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
