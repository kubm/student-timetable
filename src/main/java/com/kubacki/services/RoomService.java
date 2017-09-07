package com.kubacki.services;

import com.kubacki.domain.Room;
import com.kubacki.domain.User;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface RoomService extends CRUDService<Room>{
    List<Room> findAll();
    List<Room> findByUser(User user);
}
