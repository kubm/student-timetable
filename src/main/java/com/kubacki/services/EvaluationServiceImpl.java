package com.kubacki.services;

import com.kubacki.domain.Evaluation;
import com.kubacki.repositories.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Service
public class EvaluationServiceImpl implements EvaluationService{

    private EvaluationRepository evaluationRepository;

    @Autowired
    public void setEvaluationRepository(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public Iterable<Evaluation> listAll() {
        return evaluationRepository.findAll();
    }

    @Override
    public Evaluation getById(Integer id) {
        return evaluationRepository.findOne(id);
    }

    @Override
    public Evaluation saveOrUpdate(Evaluation domainObject) {
        return evaluationRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        evaluationRepository.delete(id);
    }
}
