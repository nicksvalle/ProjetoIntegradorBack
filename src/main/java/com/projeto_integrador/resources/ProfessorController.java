package com.projeto_integrador.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projeto_integrador.entities.Professor;
import com.projeto_integrador.dtos.ProfessorResponse;
import com.projeto_integrador.mappers.ProfessorMapper;
import com.projeto_integrador.services.ProfessorService;


public class ProfessorController { 
    @Autowired
    private ProfessorService service;

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> getProfessor() {
    var professor = this.service.getProfessor();
    return ResponseEntity.ok(ProfessorMapper.toDTOList(professor));
}



    @GetMapping("{id}")
    public ResponseEntity<ProfessorResponse>getProfessores(@PathVariable long id){
        var professores = this.service.getProfessores(id);
        return ResponseEntity.ok(ProfessorMapper.toDTO(professores));
    }
    
    
    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Validated @RequestBody Professor professor,
                                   @PathVariable long id
    ){
   
    this.service.update(id, professor);
    return ResponseEntity.ok().build();
    }


}