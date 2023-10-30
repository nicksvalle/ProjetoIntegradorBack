package com.projeto_integrador.dtos;

import jakarta.validation.constraints.NotBlank;

public record SalaRequest (

    @NotBlank(message = "Numero não pode ser em branco")
    String numero,

    @NotBlank(message = "Capacidade não pode ser em branco")
    String capacidade,

    @NotBlank(message = "Descricao não pode ser em branco")
    String descricao
){

}