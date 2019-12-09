package com.upe.alide.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	
	@Id
	private String nomeRole;
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuarios;
	
	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}
	public String getNomeRole() {
		return this.nomeRole;
	}

	@Override
	public String getAuthority() {
		return this.nomeRole;
	}
}
