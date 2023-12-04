package com.projeto_integrador.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record ClassResponse(
    Long id,
    LocalDateTime date,
    List<String> room,
    String teacher,
    String discipline,
    String course
    ) {  }