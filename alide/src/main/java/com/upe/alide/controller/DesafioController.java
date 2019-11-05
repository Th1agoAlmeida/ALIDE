
package com.upe.alide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Classe Controller pra Cadastrar Desafios
@Controller
public class DesafioController {
	
	@RequestMapping(value="desafio", method=RequestMethod.GET)
	public String desafio() {
		return "../static/desafio.html";
	}
	
}
