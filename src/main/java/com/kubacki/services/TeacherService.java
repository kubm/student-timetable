package com.kubacki.services;

import com.kubacki.domain.Teacher;
import com.kubacki.domain.User;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface TeacherService extends CRUDService<Teacher>{
    List<Teacher> findByUser(User user);

}
