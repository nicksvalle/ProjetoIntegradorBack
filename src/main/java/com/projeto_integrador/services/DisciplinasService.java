package com.projeto_integrador.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_integrador.entities.Disciplinas;
import com.projeto_integrador.repositories.DisciplinasRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DisciplinasService {
    
    @Autowired
    private DisciplinasRepository repository;

    public List<Disciplinas> getDisciplinas(){
        return this.repository.findAll();
    }

    public Disciplinas getDisciplina(long id){
        return this.repository.findById(id).orElseThrow(
                                                () -> new EntityNotFoundException("Disciplinas Nao Encontrada")

                                                
                                            );
    }
                                            public void update(long id, Disciplinas Disciplinas) {

    }
}