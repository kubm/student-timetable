package com.kubacki.services;

import com.kubacki.domain.*;

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
    List<Lesson> findByTeacher(Teacher teacher);
    List<Lesson> findBySubject_User_Id(Integer id);
    List<Lesson> findByWeekDayAndSubject_User_Id(Integer weekDay, Integer id);
}
