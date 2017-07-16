package com.kubacki.repositories;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.Subject;
import com.kubacki.domain.LessonType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-15.
 */
public interface LessonRepository extends CrudRepository<Lesson,Integer>{
    List<Lesson> findBySubject(Subject subject);
    List<Lesson> findByLessonType(LessonType lessonType);

}
