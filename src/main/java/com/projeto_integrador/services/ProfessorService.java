package com.projeto_integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_integrador.dtos.ProfessorRequest;
import com.projeto_integrador.dtos.ProfessorResponse;
import com.projeto_integrador.entities.Professor;
import com.projeto_integrador.mappers.ProfessorMapper;
import com.projeto_integrador.repositories.ProfessorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository repository;

    public List<Professor> getProfessores(){
        return this.repository.findAll();
    }

    public Professor getProfessor(long id){
        return this.repository.findById(id).orElseThrow(
                                                () -> new EntityNotFoundException("Professor Nao Encontrado")

                                                
                                            );
    }

    public void deleteProfessoresById(long id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Professor not found");
        }
    }

    public ProfessorResponse save(ProfessorRequest professor){
        var entity = this.repository.save(ProfessorMapper.toEntity(professor));
        return ProfessorMapper.toDTO(entity);
    }

    public void update(long id, Professor professor) {
        try {
            Professor updateProfessores = this.repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Professor not found")
            );
    
            updateProfessores.setName(professor.getName());
            updateProfessores.setEmail(professor.getEmail());
            updateProfessores.setCourse(professor.getCourse());
            updateProfessores.setDate(professor.getDate());
            updateProfessores.setMateria(professor.getMateria());
    
            this.repository.save(updateProfessores);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Client not found");
        }
    }
}
