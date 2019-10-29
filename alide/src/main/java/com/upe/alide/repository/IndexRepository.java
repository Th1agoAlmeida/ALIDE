package com.upe.alide.repository;

import org.springframework.data.repository.CrudRepository;

import com.upe.alide.model.Aluno;

public interface IndexRepository extends CrudRepository<Aluno, String> {

}
