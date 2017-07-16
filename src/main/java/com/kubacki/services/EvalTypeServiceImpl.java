package com.kubacki.services;

import com.kubacki.domain.EvalType;
import com.kubacki.repositories.EvalTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Service
public class EvalTypeServiceImpl implements EvalTypeService{

    private EvalTypeRepository evalTypeRepository;

    @Autowired
    public void setEvalTypeRepository(EvalTypeRepository evalTypeRepository) {
        this.evalTypeRepository = evalTypeRepository;
    }

    @Override
    public Iterable<EvalType> listAll() {
        return evalTypeRepository.findAll();
    }

    @Override
    public EvalType getById(Integer id) {
        return evalTypeRepository.findOne(id);
    }

    @Override
    public EvalType saveOrUpdate(EvalType domainObject) {
        return evalTypeRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        evalTypeRepository.delete(id);
    }
}
