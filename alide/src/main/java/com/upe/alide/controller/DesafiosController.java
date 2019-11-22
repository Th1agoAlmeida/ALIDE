package com.upe.alide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DesafiosController {
	
	@RequestMapping(value = "/desafios.html", method = RequestMethod.GET)
	public String getDesafios() {
		
		return "../static/desafios.html";
	}
	
}
