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

import com.projeto_integrador.dtos.CursoRequest;
import com.projeto_integrador.dtos.CursoResponse;
import com.projeto_integrador.entities.Curso;
import com.projeto_integrador.mappers.CursoMapper;
import com.projeto_integrador.services.CursoService;


@RestController
@RequestMapping("cursos")
@CrossOrigin

public class CursoController {
    @Autowired
    private CursoService service;

    @GetMapping
    public ResponseEntity<List<CursoResponse>> getCurso() {
    var curso = this.service.getCursos();
    return ResponseEntity.ok(CursoMapper.toDTOList(curso));
}



    @GetMapping("{id}")
    public ResponseEntity<CursoResponse>getCursos(@PathVariable long id){
        var cursos = this.service.getCurso(id);
        return ResponseEntity.ok(CursoMapper.toDTO(cursos));
    }

    @PostMapping
    public ResponseEntity<CursoResponse> save(@Validated @RequestBody CursoRequest cursos){
        var savedCursos = this.service.save(cursos);

        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedCursos.id())

                .toUri();
                
        return ResponseEntity.created(location).body(savedCursos);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCursos(@PathVariable long id){
        this.service.deleteCursosById(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Validated @RequestBody Curso curso,
                                   @PathVariable long id
    ){
   
    this.service.update(id, curso);
    return ResponseEntity.ok().build();
    }


}