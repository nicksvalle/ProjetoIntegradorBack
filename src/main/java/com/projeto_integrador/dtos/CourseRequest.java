package com.projeto_integrador.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CourseRequest(
   
    @NotBlank(message = "Nome não pode ser em branco")
    String title,

    @NotBlank(message = "Descricao não pode ser em branco")
    String discipline,

    @NotBlank(message = "Duração do Semestre não pode ser em branco")
    String course,

    @NotEmpty(message = "Sigla não pode ser em branco")
    String acronym,

    @NotBlank(message = "Duração do Semestre não pode ser em branco")
    String period
) {
    
}
