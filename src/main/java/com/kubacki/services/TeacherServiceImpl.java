package com.kubacki.services;

import com.kubacki.domain.Teacher;
import com.kubacki.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Service
public class TeacherServiceImpl implements TeacherService{
    private TeacherRepository teacherRepository;

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Iterable<Teacher> listAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getById(Integer id) {
        return teacherRepository.findOne(id);
    }

    @Override
    public Teacher saveOrUpdate(Teacher domainObject) {
        return teacherRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        teacherRepository.delete(id);
    }
}
