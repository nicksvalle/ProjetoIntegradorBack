package com.projeto_integrador.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_integrador.entities.Curso;
import com.projeto_integrador.repositories.CursoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository repository;

    public List<Curso> getCurso(){
        return this.repository.findAll();
    }

    public Curso getCursos(long id){
        return this.repository.findById(id).orElseThrow(
                                                () -> new EntityNotFoundException("Curso Nao Encontrada")

                                                
                                            );
    }
                                            public void update(long id, Curso Curso) {

    }
}