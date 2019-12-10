package com.example.demo.controller;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Aluno;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("paginaLogin");
		return mv;
	}
	
	
}
