package com.projeto_integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_integrador.entities.Sala;
import com.projeto_integrador.repositories.SalaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SalaService {
    
    @Autowired
    private SalaRepository repository;

    public List<Sala> getSala(){
        return this.repository.findAll();
    }

    public Sala getSalas(long id){
        return this.repository.findById(id).orElseThrow(
                                                () -> new EntityNotFoundException("Sala Nao Encontrado")

                                                
                                            );
    }
                                            public void update(long id, Sala Sala) {

    }
}