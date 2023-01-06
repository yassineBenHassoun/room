package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.entity.HourRoom;
import com.spring.entity.Room;
import com.spring.repository.HourRoomRepository;

public class HourRoomService
{
    @Autowired
    private HourRoomRepository hourRoomRepository;

    public HourRoom createHour(HourRoom hourRoom) {

        hourRoomRepository.save(hourRoom);

        return hourRoom;
    }

}
