package com.kubacki.services;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.Note;
import com.kubacki.domain.User;
import com.kubacki.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Service
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public void setNoteRepository(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    @Override
    public Note getById(Integer id){
        return noteRepository.findOne(id);
    }

    @Override
    public Note saveOrUpdate(Note domainObject){
        return noteRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id){
        noteRepository.delete(id);
    }

    @Override
    public Iterable<Note> listAll(){
        return noteRepository.findAll();
    }

    @Override
    public List<Note> findByLesson(Lesson lesson) {
        return noteRepository.findByLesson(lesson);
    }

    @Override
    public List<Note> listOrderedByDate() {
        return noteRepository.findAllByOrderByDateDesc();
    }

    @Override
    public List<Note> listTop5OrderedByDate() {
        return noteRepository.findTop5ByOrderByDateDesc();
    }

    @Override
    public List<Note> findTop5ByLesson_Subject_UserOrderByDateDesc(User user) {
        return noteRepository.findTop5ByLesson_Subject_UserOrderByDateDesc(user);
    }
}
