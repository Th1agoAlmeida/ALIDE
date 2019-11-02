package com.upe.alide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upe.alide.model.Aluno;
import com.upe.alide.repository.IndexRepository;

@Controller
public class IndexController {
	
	@Autowired
	private IndexRepository alunoEntity;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "../static/index.html";
	}
	
//	@RequestMapping(value = "/enviar", method = RequestMethod.POST)
//	public String indexForm(Aluno aluno) {
//		
//		alunoEntity.save(aluno);
//		
//		return "/cadastroRealizado.html";
//	}
	
}
