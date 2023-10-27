package com.projeto_integrador.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.projeto_integrador.dtos.DisciplinasResponse;
import com.projeto_integrador.mappers.DisciplinasMapper;
import com.projeto_integrador.services.DisciplinasService;



public class DisciplinasController {
    @Autowired
    private DisciplinasService service;

    @GetMapping
    public ResponseEntity<List<DisciplinasResponse>> getDisiciplinas(){
        var Disciplinas = this.service.getDisciplinas();
        return ResponseEntity.ok(DisciplinasMapper.toDTOList(disciplinas));
    }

}