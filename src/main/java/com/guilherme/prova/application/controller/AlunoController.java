package com.guilherme.prova.application.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.guilherme.prova.domain.model.Aluno;
import com.guilherme.prova.domain.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> list() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Aluno> find(@PathVariable Integer id) throws Exception {

        if(alunoRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
        return alunoRepository.findById(id);              
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody Aluno aluno){
        alunoRepository.save(aluno);
        
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
        
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestBody Aluno aluno){
        alunoRepository.save(aluno);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        alunoRepository.deleteById(id);
    }
}
