package com.upe.alide.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.upe.alide.model.Desafio;
import com.upe.alide.model.Usuario;
import com.upe.alide.repository.DesafioRepository;

@Controller
public class DesafiosController {
	
	@Autowired
	DesafioRepository dr;
	
	@RequestMapping(value = {"/desafios.html", "/desafios"}, method = RequestMethod.GET)
	public String desafios(Model model) {
		DirecionaUsuarioUrl du = new DirecionaUsuarioUrl();
		model.addAttribute("desafios", dr.findAll());
		return du.direcionaUrl("../static/desafios", "../static/desafios-professor", "../static/desafios-professor");
	
		
	}
	
	@GetMapping(value = {"/add-desafio", "/add-desafio.html"})
	public String adicionarDesafio(Model model) {
		model.addAttribute("desafio", new Desafio());// método addAttribute serve para expor um objeto à view que será retornada
		Usuario u = new Usuario();
		return "../static/add-desafio";// view que será retornada
	}
	
	@PostMapping("/add-desafio")
	public String adicionarDesafioPost(@ModelAttribute Desafio desafio) { // pega o objeto que foi adicionado a view, ele vem preenchido com os dados do formulário
	
		dr.save(desafio);// método para salvar um desafio no BD
		
		return "redirect:/confirm-desafio";
	}
	
	@GetMapping("/confirm-desafio")
	public String confirmAdicao() {
		return "../static/confirm-desafio";
	}
	
	@GetMapping("/excluir") // método para excluir um desafio do banco de dados
	public String excluirDesafio(@RequestParam int id) {
		dr.deleteById(id);
		return "redirect:/desafios.html";
	}
	
	
	
}
