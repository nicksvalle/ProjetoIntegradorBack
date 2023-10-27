package com.projeto_integrador.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projeto_integrador.entities.Disciplinas;
import com.projeto_integrador.dtos.DisciplinasResponse;
import com.projeto_integrador.mappers.DisciplinasMapper;
import com.projeto_integrador.services.DisciplinasService;



public class DisciplinasController {
    @Autowired
    private DisciplinasService service;

    @GetMapping
    public ResponseEntity<List<DisciplinasResponse>> getDisciplinas() {
    var disciplinas = this.service.getDisciplinas();
    return ResponseEntity.ok(DisciplinasMapper.toDTOList(disciplinas));
}



    @GetMapping("{id}")
    public ResponseEntity<DisciplinasResponse>getDisciplina(@PathVariable long id){
        var disciplina = this.service.getDisciplina(id);
        return ResponseEntity.ok(DisciplinasMapper.toDTO(disciplina));
    }
    
    
    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Validated @RequestBody Disciplinas disciplinas,
                                   @PathVariable long id
    ){
   
    this.service.update(id, disciplinas);
    return ResponseEntity.ok().build();
    }


}