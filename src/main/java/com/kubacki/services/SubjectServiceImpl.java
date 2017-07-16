package com.kubacki.services;

import com.kubacki.domain.Subject;
import com.kubacki.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by KUBACM on 2017-07-15.
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    private SubjectRepository subjectRepository;

    @Autowired
    public void setSubjectRepository(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Iterable<Subject> listAll(){
        return subjectRepository.findAll();
    }

    @Override
    public Subject getById(Integer id){
        return subjectRepository.findOne(id);
    }

    @Override
    public Subject saveOrUpdate(Subject domainObject) {
        return subjectRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id){
        subjectRepository.delete(id);
    }

    @Override
    public Subject findByName(String name){
        return subjectRepository.findByName(name);
    }


}
