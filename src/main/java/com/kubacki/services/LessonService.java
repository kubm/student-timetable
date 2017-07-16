package com.kubacki.services;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.Subject;
import com.kubacki.domain.LessonType;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-15.
 */
public interface LessonService extends CRUDService<Lesson>{

    List<Lesson> findBySubject(Subject subject);
    List<Lesson> findByLessonType(LessonType lessonType);
}
