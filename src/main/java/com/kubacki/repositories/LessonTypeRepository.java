package com.kubacki.repositories;

import com.kubacki.domain.LessonType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface LessonTypeRepository extends CrudRepository<LessonType,Integer> {
    LessonType findByNazwa(String nazwa);
}
