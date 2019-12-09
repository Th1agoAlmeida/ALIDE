package com.upe.alide.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {
	
	@RequestMapping(value = {"/dashboard.html", "/dashboard"}, method = RequestMethod.GET)
	public String dashboard() {
		
		return "../static/dashboard.html";
	}
	
	@GetMapping(value = {"/dash-professor", "/dash-professor.html"})
	public String dashboardProfessor() {
		return "../static/dash-professor";
	}
	
	
	@GetMapping("/sua-dashboard")
	public String retornaSuaDashboard() {
		DirecionaUsuarioUrl du = new DirecionaUsuarioUrl();
		
		return du.direcionaUrl("redirect:/dashboard", "redirect:/dash-professor", "redirect:/dash-professor");
	}
	
}
