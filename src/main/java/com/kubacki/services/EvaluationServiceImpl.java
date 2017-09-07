package com.kubacki.services;

import com.kubacki.domain.Evaluation;
import com.kubacki.domain.Lesson;
import com.kubacki.domain.Room;
import com.kubacki.domain.User;
import com.kubacki.repositories.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Evaluation> listAllOrderedByDate() {
        return evaluationRepository.findAllByOrderByDzienAsc();
    }

    @Override
    public List<Evaluation> listAllByLesson(Lesson lesson) {
        return evaluationRepository.findByLesson(lesson);
    }

    @Override
    public List<Evaluation> listFirst4Evals() {
        return evaluationRepository.findTop4ByOrderByDzienDesc();
    }

    @Override
    public List<Evaluation> findByRoom(Room room) {
        return evaluationRepository.findByRoom(room);
    }

    @Override
    public List<Evaluation> findAllByLesson_Subject_UserOrderByDzienAsc(User user) {
        return evaluationRepository.findAllByLesson_Subject_UserOrderByDzienAsc(user);
    }

    @Override
    public List<Evaluation> findTop4ByLesson_Subject_UserOrderByDzienDesc(User user) {
        return evaluationRepository.findTop4ByLesson_Subject_UserOrderByDzienDesc(user);
    }
}
