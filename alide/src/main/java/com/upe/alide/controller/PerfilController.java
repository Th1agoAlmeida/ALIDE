package com.upe.alide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PerfilController {
	
	@RequestMapping(value = "/perfil.html", method = RequestMethod.GET)
	public String perfil() {
		
		return "../static/perfil.html";
	}
	
}
