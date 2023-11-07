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

import com.projeto_integrador.entities.Sala;
import com.projeto_integrador.dtos.SalaRequest;
import com.projeto_integrador.dtos.SalaResponse;
import com.projeto_integrador.mappers.SalaMapper;
import com.projeto_integrador.services.SalaService;

@RestController
@RequestMapping("salas")
@CrossOrigin

public class SalaController {
    @Autowired
    private SalaService service;

    @GetMapping
    public ResponseEntity<List<SalaResponse>> getSala() {
        var sala = this.service.getSalas();
        return ResponseEntity.ok(SalaMapper.toDTOList(sala));
    }

    @GetMapping("{id}")
    public ResponseEntity<SalaResponse> getSalas(@PathVariable long id) {
        var salas = this.service.getSala(id);
        return ResponseEntity.ok(SalaMapper.toDTO(salas));
    }

    @PostMapping
    public ResponseEntity<SalaResponse> save(@Validated @RequestBody SalaRequest salaRequest) {
        var savedSala = this.service.save(salaRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedSala.id())
                .toUri();

        return ResponseEntity.created(location).body(savedSala);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSalas(@PathVariable long id) {
        this.service.deleteSalasById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Validated @RequestBody Sala sala, @PathVariable long id) {
        this.service.update(id, sala);
        return ResponseEntity.ok().build();
    }
}
