package com.projeto_integrador.dtos;

import jakarta.validation.constraints.NotBlank;

public record DisciplinasRequest(
   
    @NotBlank(message = "Nome não pode ser em branco")
    String name,

    @NotBlank(message = "Descricao não pode ser em branco")
    String descricao,

    @NotBlank(message = "Duração do Semestre não pode ser em branco")
    String duracaoSemestre
) {
    
}
