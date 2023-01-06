package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Room;
import com.spring.entity.Site;
import com.spring.repository.RoomRepository;

@Service
public class RoomService 
{

    @Autowired
    private RoomRepository roomRepository;

   
    public List<Room> allRooms() {

        return roomRepository.findAll();
    }


    public Room getRoomByName (String name) {
        return roomRepository.findByName(name);
    }


    public List<Room> getRoomBySite(Site site) {

        return roomRepository.findBySite(site);
    }

    
}
