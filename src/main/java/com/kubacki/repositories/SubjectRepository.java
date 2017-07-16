package com.kubacki.repositories;

import com.kubacki.domain.Subject;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by KUBACM on 2017-07-15.
 */
public interface SubjectRepository extends CrudRepository<Subject,Integer>{
    Subject findByName(String nazwa);
}
