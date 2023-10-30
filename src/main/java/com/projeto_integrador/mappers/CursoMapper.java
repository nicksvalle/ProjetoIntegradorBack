package com.projeto_integrador.mappers;

import java.util.ArrayList;
import java.util.List;

import com.projeto_integrador.dtos.CursoResponse;
import com.projeto_integrador.entities.Curso;






public class CursoMapper {

    public static CursoResponse toDTO(Curso curso) {
        return new CursoResponse(
            curso.getId(),
            curso.getName(),
            curso.getDescricao(),
            curso.getSemestre()
        );
    }

    public static List<CursoResponse> toDTOList(List<Curso> curso) {
        List<CursoResponse> result = new ArrayList<>();

        for (Curso cursos : curso) {
            result.add(toDTO(cursos));
        }

        return result;
    }
}
