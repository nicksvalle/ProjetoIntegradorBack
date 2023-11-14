package com.projeto_integrador.mappers;

import java.util.ArrayList;
import java.util.List;

import com.projeto_integrador.dtos.AulaRequest;
import com.projeto_integrador.dtos.AulaResponse;
import com.projeto_integrador.entities.Aula;

public class AulaMapper {

    public static Aula toEntity(AulaRequest request) {
        Aula aula = new Aula();
        aula.setData(request.data());
        aula.setHorario(request.horario());
        return aula;
    }


    public static AulaResponse toDTO(Aula aula) {
        return new AulaResponse(
            aula.getId(),
            aula.getData(),
            aula.getHorario()
        );
    }

    public static List<AulaResponse> toDTOList(List<Aula> aulas) {
        List<AulaResponse> result = new ArrayList<>();

        for (Aula aula : aulas) {
            result.add(toDTO(aula));
        }

        return result;
    }
}
