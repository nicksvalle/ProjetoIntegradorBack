package com.projeto_integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_integrador.dtos.SalaRequest;
import com.projeto_integrador.dtos.SalaResponse;
import com.projeto_integrador.entities.Sala;
import com.projeto_integrador.mappers.SalaMapper;
import com.projeto_integrador.repositories.SalaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SalaService {
    
    @Autowired
    private SalaRepository repository;

    public List<Sala> getSalas(){
        return this.repository.findAll();
    }

    public Sala getSala(long id){
        return this.repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Sala Não Encontrada")
        );
    }

    public void deleteSalasById(long id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Sala not found");
        }
    }

    public SalaResponse save(SalaRequest sala){
        var entity = this.repository.save(SalaMapper.toEntity(sala));
        return SalaMapper.toDTO(entity);
    }

    public void update(long id, Sala sala) {
        try {
            Sala updateSala = this.repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Sala not found")
            );
    
            updateSala.setNumero(sala.getNumero());
            updateSala.setCapacidade(sala.getCapacidade());
            updateSala.setDescricao(sala.getDescricao());
    
            this.repository.save(updateSala);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Sala not found");
        }
    }
}
