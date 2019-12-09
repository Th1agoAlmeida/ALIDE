package com.upe.alide.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class DirecionaUsuarioUrl {
	
	public String direcionaUrl(String urlAlun, String urlProf, String urlCoord) {
		String retorno = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_PROF")) {
				retorno = urlProf;
				
			} else if (grantedAuthority.getAuthority().equals("ROLE_COORD")) {
				retorno =urlCoord;
			} else {
				retorno = urlAlun;
			}
		}
		
		return retorno;
	}
}
