package com.guilherme.prova.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.guilherme.prova.domain.model.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    
}
