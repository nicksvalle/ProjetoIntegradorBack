package com.projeto_integrador.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto_integrador.dtos.ClassRequest;
import com.projeto_integrador.dtos.ClassResponse;
import com.projeto_integrador.entities.Class;
import com.projeto_integrador.mappers.ClassMapper;
import com.projeto_integrador.services.ClassService;

@RestController
@RequestMapping("class")
@CrossOrigin

public class ClassController {
    @Autowired
    private ClassService service;

    @GetMapping
    public ResponseEntity<List<ClassResponse>> getClasses() {
        var classe = this.service.getClasses();
        return ResponseEntity.ok(ClassMapper.toDTOList(classe));
    }

    @GetMapping("{id}")
    public ResponseEntity<ClassResponse> getClasses(@PathVariable long id) {
        var classes = this.service.getClass(id);
        return ResponseEntity.ok(ClassMapper.toDTO(classes));
    }

    @PostMapping
    public ResponseEntity<ClassResponse> save(@Validated @RequestBody ClassRequest classes) {
        var savedClasses = this.service.save(classes);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedClasses.id())
                .toUri();

                return ResponseEntity.created(location).body(savedClasses);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteClasses(@PathVariable long id) {
        this.service.deleteClassById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Validated @RequestBody Class classe, @PathVariable long id) {
        this.service.update(id, classe);
        return ResponseEntity.ok().build();
    }
}
