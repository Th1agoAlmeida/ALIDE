package com.upe.alide.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.upe.alide.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	
	Usuario findByLogin(String login);
}
