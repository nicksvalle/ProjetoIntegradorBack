package com.projeto_integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_integrador.dtos.RoomRequest;
import com.projeto_integrador.dtos.RoomResponse;
import com.projeto_integrador.entities.Room;
import com.projeto_integrador.mappers.RoomMapper;
import com.projeto_integrador.repositories.RoomRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository repository;

    public List<Room> getRooms(){
        return this.repository.findAll();
    }

    public Room getRoom(long id){
        return this.repository.findById(id).orElseThrow(
                                                () -> new EntityNotFoundException("Room not found")

                                                
                                            );
    }

    public void deleteRoomsById(long id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Room not found");
        }
    }

    public RoomResponse save(RoomRequest room){
        var entity = this.repository.save(RoomMapper.toEntity(room));
        return RoomMapper.toDTO(entity);
    }

    public void update(long id, Room room) {
        try {
            Room updateRooms = this.repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Room not found")
            );
    
            updateRooms.setType(room.getType());
            updateRooms.setCapacity(room.getCapacity());
    
            this.repository.save(updateRooms);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Room not found");
        }
    }
}
