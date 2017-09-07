package com.kubacki.services;

import com.kubacki.domain.Subject;
import com.kubacki.domain.User;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-15.
 */
public interface SubjectService extends CRUDService<Subject>{

    Subject findByName(String name);
    List<Subject> findByUser(User user);
}
