package com.projeto_integrador.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;


public record ClassRequest(
   
    @NotBlank(message = "Data não pode ser em branco")
    String date,

    @NotEmpty(message = "Sala não pode ser em branco")
    List<String> room,

    @NotBlank(message = "Professor não pode ser em branco")
    String teacher,

    @NotBlank(message = "Materia não pode ser em branco")
    String discipline,

    @NotBlank(message = "Curso não pode ser em branco")
    String course
) {
    
}
