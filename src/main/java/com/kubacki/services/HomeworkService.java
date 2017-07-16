package com.kubacki.services;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.Homework;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface HomeworkService extends CRUDService<Homework>{

    List<Homework> findByTytul(String tytul);
    List<Homework> findByLesson(Lesson lesson);
}
