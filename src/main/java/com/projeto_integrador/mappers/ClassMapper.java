package com.projeto_integrador.mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.projeto_integrador.dtos.ClassRequest;
import com.projeto_integrador.dtos.ClassResponse;
import com.projeto_integrador.entities.Class;

public class ClassMapper {

    public static Class toEntity(ClassRequest request) {
        Class classe = new Class();
        LocalDateTime date = LocalDateTime.parse(request.date(), DateTimeFormatter.ISO_DATE_TIME);
        classe.setDate(date);
        classe.setRoom(request.room());
        classe.setTeacher(request.teacher());
        classe.setDiscipline(request.discipline());
        classe.setCourse(request.course());
        return classe;
    }


    public static ClassResponse toDTO(Class classe) {
        return new ClassResponse(
            classe.getId(),
            classe.getDate(),
            classe.getRoom(),
            classe.getTeacher(),
            classe.getDiscipline(),
            classe.getCourse()
        );
    }

    public static List<ClassResponse> toDTOList(List<Class> classes) {
        List<ClassResponse> result = new ArrayList<>();

        for (Class classe : classes) {
            result.add(toDTO(classe));
        }

        return result;
    }
}
