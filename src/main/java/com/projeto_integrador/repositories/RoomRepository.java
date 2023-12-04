package com.projeto_integrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto_integrador.entities.Room;


public interface RoomRepository extends JpaRepository<Room, Long>  {
    
}
