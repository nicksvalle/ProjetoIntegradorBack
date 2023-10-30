package com.projeto_integrador.dtos;

import jakarta.validation.constraints.NotBlank;

public record CursoRequest(
   
    @NotBlank(message = "Nome não pode ser em branco")
    String nome,

    @NotBlank(message = "Descricao não pode ser em branco")
    String descricao,

    @NotBlank(message = "Duração do Semestre não pode ser em branco")
    String Semestre
) {
    
}
