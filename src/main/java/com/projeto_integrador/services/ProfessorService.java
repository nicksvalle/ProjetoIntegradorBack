package com.projeto_integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_integrador.entities.Professor;
import com.projeto_integrador.repositories.ProfessorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository repository;

    public List<Professor> getProfessor(){
        return this.repository.findAll();
    }

    public Professor getProfessores(long id){
        return this.repository.findById(id).orElseThrow(
                                                () -> new EntityNotFoundException("Professor Nao Encontrado")

                                                
                                            );
    }
                                            public void update(long id, Professor Professor) {

    }
}