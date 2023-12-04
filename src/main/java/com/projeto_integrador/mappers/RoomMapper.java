package com.projeto_integrador.mappers;

import java.util.ArrayList;
import java.util.List;

import com.projeto_integrador.dtos.RoomRequest;
import com.projeto_integrador.dtos.RoomResponse;
import com.projeto_integrador.entities.Room;



public class RoomMapper {
    public static Room toEntity(RoomRequest request) {
        Room room = new Room();
        room.setType(request.type());
        room.setCapacity(request.capacity());
        room.setNumber(request.number());
        return room;
    }

    public static RoomResponse toDTO(Room room) {
        return new RoomResponse(
            room.getId(),
            room.getType(),
            room.getCapacity(),
            room.getNumber()
        );
    }

    public static List<RoomResponse> toDTOList(List<Room> room) {
        List<RoomResponse> result = new ArrayList<>();

        for (Room rooms : room) {
            result.add(toDTO(rooms));
        }

        return result;
    }
}
