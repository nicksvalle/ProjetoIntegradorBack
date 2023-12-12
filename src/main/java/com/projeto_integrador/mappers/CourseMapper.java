package com.projeto_integrador.mappers;

import java.util.ArrayList;
import java.util.List;

import com.projeto_integrador.dtos.CourseRequest;
import com.projeto_integrador.dtos.CourseResponse;
import com.projeto_integrador.entities.Course;


    public class CourseMapper {

        public static Course toEntity(CourseRequest request) {
            Course course = new Course();
            course.setTitle(request.title());
            course.setDiscipline(request.discipline());
            course.setCourse(request.course());
            course.setAcronym(request.acronym());
            course.setPeriod(request.period());
            return course;
        }

    public static CourseResponse toDTO(Course course) {
        return new CourseResponse(
            course.getId(),
            course.getTitle(),
            course.getDiscipline(),
            course.getCourse(),
            course.getAcronym(),
            course.getPeriod()
        );
    }

    public static List<CourseResponse> toDTOList(List<Course> course) {
        List<CourseResponse> result = new ArrayList<>();

        for (Course courses : course) {
            result.add(toDTO(courses));
        }

        return result;
    }
}
