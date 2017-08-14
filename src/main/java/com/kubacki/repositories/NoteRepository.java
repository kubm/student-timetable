package com.kubacki.repositories;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface NoteRepository extends CrudRepository<Note,Integer>{
    List<Note> findByLesson(Lesson lesson);
}
