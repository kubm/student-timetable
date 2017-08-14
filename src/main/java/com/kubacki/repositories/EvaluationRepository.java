package com.kubacki.repositories;

import com.kubacki.domain.Evaluation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface EvaluationRepository extends CrudRepository<Evaluation, Integer>{
    List<Evaluation> findAllByOrderByDzienAsc();
}
