package com.projeto_integrador.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.projeto_integrador.dtos.DisciplinasRequest;
import com.projeto_integrador.dtos.DisciplinasResponse;
import com.projeto_integrador.entities.Disciplinas;


public class DisciplinasMapper {

    public static DisciplinasResponse toDTO(Disciplinas disciplinas){
        return new DisciplinaResponse (disciplinas.getId(), 
        disciplinas.getNome(),
        disciplinas.getDescricao(),
        disciplinas.getDuracaoSemestres());
    }

    public static List<DisciplinasResponse> toDTOList(List<Disciplinas> disciplinas){
        return disciplinas.stream()      
               .map(DisciplinasMapper::toDTO)
               .collect(Collectors.toList());
    }
}
    