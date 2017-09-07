package com.kubacki.repositories;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.Note;
import com.kubacki.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface NoteRepository extends CrudRepository<Note,Integer>{
    List<Note> findByLesson(Lesson lesson);
    List<Note> findAllByOrderByDateDesc();
    List<Note> findTop5ByOrderByDateDesc();
    List<Note> findTop5ByLesson_Subject_UserOrderByDateDesc(User user);
}
