package com.kubacki.repositories;

import com.kubacki.domain.Subject;
import com.kubacki.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-15.
 */
public interface SubjectRepository extends CrudRepository<Subject,Integer>{
    Subject findByName(String nazwa);
    List<Subject> findByUser(User user);
}
