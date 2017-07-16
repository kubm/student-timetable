package com.kubacki.services;

import com.kubacki.domain.LessonType;
import com.kubacki.repositories.LessonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Service
public class LessonTypeServiceImpl implements LessonTypeService {
    private LessonTypeRepository lessonTypeRepository;

    @Autowired
    public void setLessonTypeRepository(LessonTypeRepository lessonTypeRepository){
        this.lessonTypeRepository = lessonTypeRepository;
    }

    @Override
    public Iterable<LessonType> listAll(){
        return  lessonTypeRepository.findAll();
    }

    @Override
    public LessonType getById(Integer id){
        return lessonTypeRepository.findOne(id);
    }

    @Override
    public LessonType saveOrUpdate(LessonType domainObject){
        return  lessonTypeRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id){
        lessonTypeRepository.delete(id);
    }

    @Override
    public LessonType findByNazwa(String nazwa){
        return lessonTypeRepository.findByNazwa(nazwa);
    }
}
