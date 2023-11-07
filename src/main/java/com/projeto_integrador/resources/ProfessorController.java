package com.projeto_integrador.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto_integrador.entities.Professor;
import com.projeto_integrador.dtos.ProfessorRequest;
import com.projeto_integrador.dtos.ProfessorResponse;
import com.projeto_integrador.mappers.ProfessorMapper;
import com.projeto_integrador.services.ProfessorService;

@RestController
@RequestMapping("professores")
@CrossOrigin

public class ProfessorController { 
    @Autowired
    private ProfessorService service;

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> getProfessor() {
    var professor = this.service.getProfessores();
    return ResponseEntity.ok(ProfessorMapper.toDTOList(professor));
}



    @GetMapping("{id}")
    public ResponseEntity<ProfessorResponse>getProfessores(@PathVariable long id){
        var professores = this.service.getProfessor(id);
        return ResponseEntity.ok(ProfessorMapper.toDTO(professores));
    }
    
    @PostMapping
    public ResponseEntity<ProfessorResponse> save(@Validated @RequestBody ProfessorRequest professores){
        var savedProfessores = this.service.save(professores);

        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedProfessores.id())

                .toUri();
                
        return ResponseEntity.created(location).body(savedProfessores);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProfessores(@PathVariable long id){
        this.service.deleteProfessoresById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Validated @RequestBody Professor professor,
                                   @PathVariable long id
    ){
   
        this.service.update(id, professor);
        return ResponseEntity.ok().build();
    }



}