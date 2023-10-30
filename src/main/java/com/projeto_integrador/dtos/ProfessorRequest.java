package com.projeto_integrador.dtos;

import jakarta.validation.constraints.NotBlank;

public record ProfessorRequest (

    @NotBlank(message = "Nome não pode ser em branco")
    String name,

    @NotBlank(message = "Email não pode ser em branco")
    String email,

    @NotBlank(message = "Curso não pode ser em branco")
    String course,

    @NotBlank(message = "Data não pode ser em branco")
    String date,

    @NotBlank(message = "Materia não pode ser em branco")
    String materia

){

}