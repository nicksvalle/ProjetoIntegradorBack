package com.projeto_integrador.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projeto_integrador.dtos.CursoResponse;
import com.projeto_integrador.entities.Curso;
import com.projeto_integrador.mappers.CursoMapper;
import com.projeto_integrador.services.CursoService;




public class CursoController {
    @Autowired
    private CursoService service;

    @GetMapping
    public ResponseEntity<List<CursoResponse>> getCurso() {
    var curso = this.service.getCurso();
    return ResponseEntity.ok(CursoMapper.toDTOList(curso));
}



    @GetMapping("{id}")
    public ResponseEntity<CursoResponse>getCursos(@PathVariable long id){
        var cursos = this.service.getCursos(id);
        return ResponseEntity.ok(CursoMapper.toDTO(cursos));
    }
    
    
    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Validated @RequestBody Curso curso,
                                   @PathVariable long id
    ){
   
    this.service.update(id, curso);
    return ResponseEntity.ok().build();
    }


}