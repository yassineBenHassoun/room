package com.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.HourRoom;
import com.spring.entity.Room;


@Repository
public interface HourRoomRepository extends CrudRepository<HourRoom, Long> 
{
    List<HourRoom> findAll();

    List<HourRoom> findByRoom(Room room);

}
