package com.kubacki.services;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.Note;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface NoteService extends CRUDService<Note>{
    List<Note> findByLesson(Lesson lesson);
}
