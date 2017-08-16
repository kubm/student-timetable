package com.kubacki.services;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.LessonType;
import com.kubacki.domain.Room;
import com.kubacki.domain.Subject;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-15.
 */
public interface LessonService extends CRUDService<Lesson>{

    List<Lesson> findBySubject(Subject subject);
    List<Lesson> findByLessonType(LessonType lessonType);
    List<Lesson> findAllByOrderByWeekDayAsc();
    List<Lesson> findByWeekDay(Integer weekDay);
    List<Lesson> findByRoom(Room room);
}
