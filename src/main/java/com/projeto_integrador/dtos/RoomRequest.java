package com.projeto_integrador.dtos;

import jakarta.validation.constraints.NotBlank;

public record RoomRequest(

    @NotBlank(message = "Tipo não pode ser em branco")
    String type,

    @NotBlank(message = "Capacidade não pode ser em branco")
    String capacity,

    @NotBlank(message = "Numero da  não pode ser em branco")
    String number
) {

    
}
