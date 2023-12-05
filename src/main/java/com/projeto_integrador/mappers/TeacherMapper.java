package com.projeto_integrador.mappers;

import java.util.ArrayList;
import java.util.List;

import com.projeto_integrador.dtos.TeacherRequest;
import com.projeto_integrador.dtos.TeacherResponse;
import com.projeto_integrador.entities.Teacher;


public class TeacherMapper {

    public static Teacher toEntity(TeacherRequest request) {
        Teacher teacher = new Teacher();
        teacher.setName(request.name());
        teacher.setEmail(request.email());
        teacher.setCourse(request.course());
        teacher.setDate(request.date());
        teacher.setDiscipline(request.discipline());
        return teacher;
    }

    public static TeacherResponse toDTO(Teacher teacher) {
        return new TeacherResponse(
            teacher.getId(),
            teacher.getName(),
            teacher.getEmail(),
            teacher.getCourse(),
            teacher.getDate(),
            teacher.getDiscipline()
        );
    }

    public static List<TeacherResponse> toDTOList(List<Teacher> teacher) {
        List<TeacherResponse> result = new ArrayList<>();

        for (Teacher teachers : teacher) {
            result.add(toDTO(teachers));
        }

        return result;
    }
}
