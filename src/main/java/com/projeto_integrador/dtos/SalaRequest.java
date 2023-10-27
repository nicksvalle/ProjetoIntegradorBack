package com.projeto_integrador.dtos;

import jakarta.validation.constraints.NotBlank;

public record SalaRequest (

    @NotBlank(message = "Nome não pode ser em branco")
    String nome,

    @NotBlank(message = "Capacidade não pode ser em branco")
    String capacidade,

    @NotBlank(message = "Descricao não pode ser em branco")
    String descricao
){

}