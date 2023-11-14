package com.projeto_integrador.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record ProfessorRequest (

    @NotBlank(message = "Nome não pode ser em branco")
    String name,

    @NotBlank(message = "Email não pode ser em branco")
    String email,

    @NotEmpty(message = "Curso não pode ser em branco")
    List<String> course,

    @NotBlank(message = "Data não pode ser em branco")
    String date,

    @NotEmpty(message = "Materia não pode ser em branco")
    List<String> materia

){

}