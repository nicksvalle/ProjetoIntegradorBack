package com.projeto_integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_integrador.dtos.ClassRequest;
import com.projeto_integrador.dtos.ClassResponse;
import com.projeto_integrador.entities.Class;
import com.projeto_integrador.mappers.ClassMapper;
import com.projeto_integrador.repositories.ClassRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClassService {

    @Autowired
    private ClassRepository repository;

    public List<Class> getClasses() {
        return this.repository.findAll();
    }

    public Class getClass(long id) {
        return this.repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Aula não encontrada")
        );
    }

    public void deleteClassById(long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Aula não encontrada");
        }
    }

    public ClassResponse save(ClassRequest classe) {
        var entity = this.repository.save(ClassMapper.toEntity(classe));
        return ClassMapper.toDTO(entity);
    }

    public void update(long id, Class classe) {
        try {
            Class updateClasses = this.repository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("Aula não encontrada")
            );

            updateClasses.setDate(classe.getDate());

            this.repository.save(updateClasses);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Aula não encontrada");
        }
    }
}
