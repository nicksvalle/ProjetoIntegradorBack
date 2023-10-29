package com.projeto_integrador.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projeto_integrador.dtos.SalaResponse;
import com.projeto_integrador.entities.Sala;
import com.projeto_integrador.mappers.SalaMapper;
import com.projeto_integrador.services.SalaService;


public class SalaController { 
    @Autowired
    private SalaService service;

    @GetMapping
    public ResponseEntity<List<SalaResponse>> getSala() {
    var sala = this.service.getSala();
    return ResponseEntity.ok(SalaMapper.toDTOList(sala));
}



    @GetMapping("{id}")
    public ResponseEntity<SalaResponse>getSalas(@PathVariable long id){
        var salas = this.service.getSalas(id);
        return ResponseEntity.ok(SalaMapper.toDTO(salas));
    }
    
    
    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Validated @RequestBody Sala sala,
                                   @PathVariable long id
    ){
   
    this.service.update(id, sala);
    return ResponseEntity.ok().build();
    }


}