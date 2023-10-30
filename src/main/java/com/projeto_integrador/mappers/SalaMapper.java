package com.projeto_integrador.mappers;

import java.util.ArrayList;
import java.util.List;

import com.projeto_integrador.dtos.SalaResponse;
import com.projeto_integrador.entities.Sala;



public class SalaMapper {

    public static SalaResponse toDTO(Sala sala) {
        return new SalaResponse(
            sala.getId(),
            sala.getNumero(),
            sala.getCapacidade(),
            sala.getDescricao()
        );
    }

    public static List<SalaResponse> toDTOList(List<Sala> sala) {
        List<SalaResponse> result = new ArrayList<>();

        for (Sala salas : sala) {
            result.add(toDTO(salas));
        }

        return result;
    }
}
