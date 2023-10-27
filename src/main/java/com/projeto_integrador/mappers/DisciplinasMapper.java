package com.projeto_integrador.mappers;

import java.util.ArrayList;
import java.util.List;



import com.projeto_integrador.dtos.DisciplinasResponse;
import com.projeto_integrador.entities.Disciplinas;


public class DisciplinasMapper {

    public static DisciplinasResponse toDTO(Disciplinas disciplinas) {
        return new DisciplinasResponse(
            disciplinas.getId(),
            disciplinas.getNome(),
            disciplinas.getDescricao(),
            disciplinas.getDuracaoSemestres()
        );
    }

    public static List<DisciplinasResponse> toDTOList(List<Disciplinas> disciplinas) {
        List<DisciplinasResponse> result = new ArrayList<>();

        for (Disciplinas disciplina : disciplinas) {
            result.add(toDTO(disciplina));
        }

        return result;
    }
}
