package com.projeto_integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_integrador.dtos.AulaRequest;
import com.projeto_integrador.dtos.AulaResponse;
import com.projeto_integrador.entities.Aula;
import com.projeto_integrador.mappers.AulaMapper;
import com.projeto_integrador.repositories.AulaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AulaService {

    @Autowired
    private AulaRepository repository;

    public List<Aula> getAulas() {
        return this.repository.findAll();
    }

    public Aula getAula(long id) {
        return this.repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Aula não encontrada")
        );
    }

    public void deleteAulaById(long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Aula não encontrada");
        }
    }

    public AulaResponse save(AulaRequest aula) {
        var entity = this.repository.save(AulaMapper.toEntity(aula));
        return AulaMapper.toDTO(entity);
    }

    public void update(long id, Aula aula) {
        try {
            Aula updateAulas = this.repository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("Aula não encontrada")
            );

            updateAulas.setData(aula.getData());
            updateAulas.setHorario(aula.getHorario());

            this.repository.save(updateAulas);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Aula não encontrada");
        }
    }
}
