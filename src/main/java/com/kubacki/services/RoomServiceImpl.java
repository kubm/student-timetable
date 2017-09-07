package com.kubacki.services;

import com.kubacki.domain.Room;
import com.kubacki.domain.User;
import com.kubacki.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Service
public class RoomServiceImpl implements RoomService{
    private RoomRepository roomRepository;

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Iterable<Room> listAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room getById(Integer id) {
        return roomRepository.findOne(id);
    }

    @Override
    public Room saveOrUpdate(Room domainObject) {
        return roomRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        roomRepository.delete(id);
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAllBy();
    }

    @Override
    public List<Room> findByUser(User user) {
        return roomRepository.findByUser(user);
    }
}
