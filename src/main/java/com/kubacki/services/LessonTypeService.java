package com.kubacki.services;

import com.kubacki.domain.LessonType;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface LessonTypeService extends CRUDService<LessonType>{

    LessonType findByNazwa(String nazwa);

}
