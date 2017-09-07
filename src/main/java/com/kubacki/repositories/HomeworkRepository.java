package com.kubacki.repositories;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.Homework;
import com.kubacki.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface HomeworkRepository extends CrudRepository<Homework, Integer>{
    List<Homework> findByTitle(String title);
    List<Homework> findByLesson(Lesson lesson);
    List<Homework> findByLesson_Subject_User(User user);
}
