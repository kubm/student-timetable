package com.kubacki.services;

import com.kubacki.domain.Evaluation;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface EvaluationService extends CRUDService<Evaluation>{
    List<Evaluation> listAllOrderedByDate();
}
