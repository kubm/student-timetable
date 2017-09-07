package com.kubacki.repositories;

import com.kubacki.domain.Evaluation;
import com.kubacki.domain.Lesson;
import com.kubacki.domain.Room;
import com.kubacki.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by KUBACM on 2017-07-16.
 */
public interface EvaluationRepository extends CrudRepository<Evaluation, Integer>{
    List<Evaluation> findAllByOrderByDzienAsc();
    List<Evaluation> findByLesson(Lesson lesson);
    List<Evaluation> findTop4ByOrderByDzienDesc();
    List<Evaluation> findTop4ByLesson_Subject_UserOrderByDzienDesc(User user);
    List<Evaluation> findByRoom(Room room);
    List<Evaluation> findAllByLesson_Subject_UserOrderByDzienAsc(User user);
}
