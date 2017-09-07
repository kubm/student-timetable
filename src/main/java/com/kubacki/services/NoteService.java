package com.kubacki.services;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.Note;
import com.kubacki.domain.User;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface NoteService extends CRUDService<Note>{
    List<Note> findByLesson(Lesson lesson);
    List<Note> listOrderedByDate();
    List<Note> listTop5OrderedByDate();
    List<Note> findTop5ByLesson_Subject_UserOrderByDateDesc(User user);
}
