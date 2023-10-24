package com.projeto_integrador.dtos;

import jakarta.validation.constraints.NotBlank;

public record ProfessorRequest (

    @NotBlank(message = "Nome não pode ser em branco")
    String name,

    @NotBlank(message = "Email não pode ser em branco")
    String email

){

}