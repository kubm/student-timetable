package com.kubacki.repositories;

import com.kubacki.domain.Teacher;
import com.kubacki.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface TeacherRepository extends CrudRepository<Teacher, Integer>{
    List<Teacher> findByUser(User user);
}
