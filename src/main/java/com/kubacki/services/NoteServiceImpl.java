package com.kubacki.services;

import com.kubacki.domain.Note;
import com.kubacki.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
