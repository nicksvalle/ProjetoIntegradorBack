package com.projeto_integrador.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_integrador.dtos.CursoRequest;
import com.projeto_integrador.dtos.CursoResponse;
import com.projeto_integrador.entities.Curso;
import com.projeto_integrador.mappers.CursoMapper;
import com.projeto_integrador.repositories.CursoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository repository;

    public List<Curso> getCursos(){
        return this.repository.findAll();
    }

    public Curso getCurso(long id){
        return this.repository.findById(id).orElseThrow(
                                                () -> new EntityNotFoundException("Curso Nao Encontrado")

                                                
                                            );
    }

    public void deleteCursosById(long id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Curso not found");
        }
    }

    public CursoResponse save(CursoRequest curso){
        var entity = this.repository.save(CursoMapper.toEntity(curso));
        return CursoMapper.toDTO(entity);
    }

    public void update(long id, Curso curso) {
        try {
            Curso updateCursos = this.repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Curso not found")
            );
    
            updateCursos.setName(curso.getName());
            updateCursos.setDescricao(curso.getDescricao());
            updateCursos.setSemestre(curso.getSemestre());
        
            
    
            this.repository.save(updateCursos);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Client not found");
        }
    }
}
