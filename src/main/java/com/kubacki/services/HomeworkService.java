package com.kubacki.services;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.Homework;
import com.kubacki.domain.User;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface HomeworkService extends CRUDService<Homework>{

    List<Homework> findByTitle(String title);
    List<Homework> findByLesson(Lesson lesson);
    List<Homework> findByLesson_Subject_User(User user);
}
