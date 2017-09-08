package com.kubacki.repositories;

import com.kubacki.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-15.
 */
public interface LessonRepository extends CrudRepository<Lesson,Integer>, JpaRepository<Lesson,Integer>{
    List<Lesson> findBySubject(Subject subject);
    List<Lesson> findByLessonType(LessonType lessonType);
    List<Lesson> findAllByOrderByWeekDayAsc();
    List<Lesson> findAllBySubject_UserOrderByWeekDayAsc(User user);
    List<Lesson> findByWeekDay(Integer weekDay);
    List<Lesson> findByRoom(Room room);
    List<Lesson> findByTeacher(Teacher teacher);
    List<Lesson> findBySubject_User(User user);
    List<Lesson> findByWeekDayAndSubject_User(Integer weekDay, User user);
    List<Lesson> findAllByOrderById();

}
