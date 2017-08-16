package com.kubacki.services;

import com.kubacki.domain.Evaluation;
import com.kubacki.domain.Lesson;
import com.kubacki.domain.Room;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface EvaluationService extends CRUDService<Evaluation>{
    List<Evaluation> listAllOrderedByDate();
    List<Evaluation> listAllByLesson(Lesson lesson);
    List<Evaluation> listFirst4Evals();
    List<Evaluation> findByRoom(Room room);
}
