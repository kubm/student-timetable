package com.kubacki.services;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.Homework;
import com.kubacki.repositories.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Service
public class HomeworkServiceImpl implements HomeworkService {

    private HomeworkRepository homeworkRepository;

    @Autowired
    public void setHomeworkRepository(HomeworkRepository homeworkRepository){
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public List<Homework> findByTytul(String tytul){
        return homeworkRepository.findByTytul(tytul);
    }

    @Override
    public List<Homework> findByLesson(Lesson lesson){
        return homeworkRepository.findByLesson(lesson);
    }

    @Override
    public Homework getById(Integer id){
        return homeworkRepository.findOne(id);
    }

    @Override
    public Homework saveOrUpdate(Homework domainObject){
        return homeworkRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id){
        homeworkRepository.delete(id);
    }

    @Override
    public Iterable<Homework> listAll(){
        return homeworkRepository.findAll();
    }
}
