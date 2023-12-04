package com.projeto_integrador.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto_integrador.dtos.RoomRequest;
import com.projeto_integrador.dtos.RoomResponse;
import com.projeto_integrador.entities.Room;
import com.projeto_integrador.mappers.RoomMapper;
import com.projeto_integrador.services.RoomService;


@RestController
@RequestMapping("rooms")
@CrossOrigin
public class RoomController {
    @Autowired
    private RoomService service;

    @GetMapping
    public ResponseEntity<List<RoomResponse>> getRoom() {
    var room = this.service.getRooms();
    return ResponseEntity.ok(RoomMapper.toDTOList(room));
}



    @GetMapping("{id}")
    public ResponseEntity<RoomResponse>getRooms(@PathVariable long id){
        var room = this.service.getRoom(id);
        return ResponseEntity.ok(RoomMapper.toDTO(room));
    }
    
    @PostMapping
    public ResponseEntity<RoomResponse> save(@Validated @RequestBody RoomRequest rooms){
        var savedRooms = this.service.save(rooms);

        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedRooms.id())

                .toUri();
                
        return ResponseEntity.created(location).body(savedRooms);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable long id){
        this.service.deleteRoomsById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Validated @RequestBody Room room,
                                   @PathVariable long id
    ){
   
        this.service.update(id, room);
        return ResponseEntity.ok().build();
    }
}
