package com.upe.alide.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.upe.alide.model.Role;
import com.upe.alide.model.Usuario;
import com.upe.alide.model.UsuarioCadastro;
import com.upe.alide.repository.UsuarioRepository;

@Controller
public class CadastroController {
	
	@Autowired
	UsuarioRepository ur;
	
	@GetMapping(value= {"/cadastro", "cadastro.html"})
	public String cadastUsuario(Model model) {
		model.addAttribute("userCadast", new UsuarioCadastro());
		return "../static/cadastro";
	}
	
	@PostMapping("/cadastro")
	public String cadastUsuarioSubmit(@ModelAttribute UsuarioCadastro usuarioCadastro) {
		Usuario usuario = new Usuario();
		System.out.println(usuario.getLogin());
		usuario.setLogin(usuarioCadastro.getLogin());
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuarioCadastro.getPassword()));
		
		ArrayList<Role> usuarioRole = new ArrayList<Role>();
		Role role = new Role();
		role.setNomeRole(usuarioCadastro.getRole());
		usuarioRole.add(role);
		usuario.setRoles(usuarioRole);
		
		ur.save(usuario);
		return "redirect:/confirm-cadastro";
	}
	
	@GetMapping("/confirm-cadastro")
	public String confimCadastro() {
		return "../static/confirm-cadastro"; 
	}
}