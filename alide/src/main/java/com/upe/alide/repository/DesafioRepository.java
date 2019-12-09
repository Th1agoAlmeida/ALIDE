package com.upe.alide.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.upe.alide.model.Desafio;

//Primeiro parâmetro do JpaRepository é o objeto que representa a entidade do BD e o segundo parâmetro 
// é o tipo da chave primária dessa entidade
public interface DesafioRepository extends JpaRepository<Desafio, Integer>{ 
	
	
}
