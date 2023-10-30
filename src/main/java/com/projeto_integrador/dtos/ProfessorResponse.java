package com.projeto_integrador.dtos;

public record ProfessorResponse (
    Long id,
    String name,
    String email,
    String course,
    String date,
    String materia
) {

}