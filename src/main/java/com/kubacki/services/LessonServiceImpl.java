package com.kubacki.services;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.LessonType;
import com.kubacki.domain.Room;
import com.kubacki.domain.Subject;
import com.kubacki.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Service
public class LessonServiceImpl implements LessonService {

    private LessonRepository lessonRepository;


    @Autowired
    public void setLessonRepository(LessonRepository lessonRepository){
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<Lesson> findBySubject(Subject subject){
        return lessonRepository.findBySubject(subject);
    }

    @Override
    public List<Lesson> findByLessonType(LessonType lessonType) {
        return lessonRepository.findByLessonType(lessonType);
    }

    @Override
    public Lesson getById(Integer id){
        return lessonRepository.findOne(id);
    }

    @Override
    public Lesson saveOrUpdate(Lesson domainObject) {
        return lessonRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id){
        lessonRepository.delete(id);
    }

    @Override
    public Iterable<Lesson> listAll(){
        return lessonRepository.findAll();
    }

    @Override
    public List<Lesson> findAllByOrderByWeekDayAsc() {
        return lessonRepository.findAllByOrderByWeekDayAsc();
    }

    @Override
    public List<Lesson> findByWeekDay(Integer weekDay) {
        return lessonRepository.findByWeekDay(weekDay);
    }

    @Override
    public List<Lesson> findByRoom(Room room) {
        return lessonRepository.findByRoom(room);
    }
}
