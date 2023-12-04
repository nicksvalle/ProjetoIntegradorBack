package com.projeto_integrador.dtos;

import java.util.List;

public record CourseResponse(
    Long id,
    String title,
    String discipline,
    String course,
    String acronym,
    List<String> teacher,
    String period
    ) {

        
}