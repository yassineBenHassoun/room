package com.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Room;
import com.spring.entity.Site;

@Repository
public interface RoomRepository  extends CrudRepository <Room, Long> 
{
    Room findByName(String name);

    List<Room> findAll();

    List<Room> findBySite(Site site);
}

