package com.projeto_integrador.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto_integrador.dtos.AulaRequest;
import com.projeto_integrador.dtos.AulaResponse;
import com.projeto_integrador.entities.Aula;
import com.projeto_integrador.mappers.AulaMapper;
import com.projeto_integrador.services.AulaService;

@RestController
@RequestMapping("aulas")
@CrossOrigin

public class AulaController {
    @Autowired
    private AulaService service;

    @GetMapping
    public ResponseEntity<List<AulaResponse>> getAulas() {
        var aula = this.service.getAulas();
        return ResponseEntity.ok(AulaMapper.toDTOList(aula));
    }

    @GetMapping("{id}")
    public ResponseEntity<AulaResponse> getAulas(@PathVariable long id) {
        var aulas = this.service.getAula(id);
        return ResponseEntity.ok(AulaMapper.toDTO(aulas));
    }

    @PostMapping
    public ResponseEntity<AulaResponse> save(@Validated @RequestBody AulaRequest aulas) {
        var savedAulas = this.service.save(aulas);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAulas.id())
                .toUri();

                return ResponseEntity.created(location).body(savedAulas);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAulas(@PathVariable long id) {
        this.service.deleteAulaById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Validated @RequestBody Aula aula, @PathVariable long id) {
        this.service.update(id, aula);
        return ResponseEntity.ok().build();
    }
}
