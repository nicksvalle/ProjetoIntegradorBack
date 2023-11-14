package com.projeto_integrador.dtos;

import jakarta.validation.constraints.NotBlank;


public record AulaRequest(
   

    @NotBlank(message = "Data não pode ser em branco")
    String data,

    @NotBlank(message = "Horário não pode ser em branco")
    String horario
) {
    
}
