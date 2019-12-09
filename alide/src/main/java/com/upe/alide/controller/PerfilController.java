package com.upe.alide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PerfilController {
	
	@RequestMapping(value = {"/perfil.html", "/perfil"}, method = RequestMethod.GET)
	public String perfil() {
		DirecionaUsuarioUrl du = new DirecionaUsuarioUrl();
		
		return du.direcionaUrl("../static/perfil.html", "../static/perfil-professor", "../static/perfil-professor");
		
	}
	
}
