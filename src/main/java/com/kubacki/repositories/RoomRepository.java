package com.kubacki.repositories;

import com.kubacki.domain.Room;
import com.kubacki.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface RoomRepository extends CrudRepository<Room, Integer>{
    List<Room> findAllBy();
    List<Room> findByUser(User user);
}
