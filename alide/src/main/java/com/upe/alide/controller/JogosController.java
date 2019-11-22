package com.upe.alide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JogosController {
	
	@RequestMapping(value = "/jogos", method = RequestMethod.GET)
	public String getJogos() {
		
		return "../static/jogos.html";
	}
	
}
