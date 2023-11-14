package com.projeto_integrador.dtos;

import java.util.List;

public record ProfessorResponse (
    Long id,
    String name,
    String email,
    List<String> course,
    String date,
    List<String> materia
) {

}