package com.projeto_integrador.mappers;

import java.util.ArrayList;
import java.util.List;

import com.projeto_integrador.dtos.ProfessorRequest;
import com.projeto_integrador.dtos.ProfessorResponse;
import com.projeto_integrador.entities.Professor;


public class ProfessorMapper {

    public static Professor toEntity(ProfessorRequest request) {
        Professor professor = new Professor();
        professor.setName(request.name());
        professor.setEmail(request.email());
        professor.setCourse(request.course());
        professor.setDate(request.date());
        professor.setMateria(request.materia());
        return professor;
    }

    public static ProfessorResponse toDTO(Professor professor) {
        return new ProfessorResponse(
            professor.getId(),
            professor.getName(),
            professor.getEmail(),
            professor.getCourse(),
            professor.getDate(),
            professor.getMateria()
        );
    }

    public static List<ProfessorResponse> toDTOList(List<Professor> professor) {
        List<ProfessorResponse> result = new ArrayList<>();

        for (Professor professores : professor) {
            result.add(toDTO(professores));
        }

        return result;
    }
}
