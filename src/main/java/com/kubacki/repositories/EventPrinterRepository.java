package com.kubacki.repositories;

import com.kubacki.domain.Evaluation;
import com.kubacki.domain.EventList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventPrinterRepository extends JpaRepository<Evaluation, Integer> {
    @Query(value = "select new com.kubacki.domain.EventList(e.id, s.name, lt.nazwa,et.nazwa,e.dzien,e.hour,e.endHour,s.colour) from " +
            "Evaluation e, Subject s, LessonType lt, EvalType et, Lesson l " +
            "where l.lessonType.id = lt.id and e.lesson.id = l.id and l.subject.id=s.id and e.evaluationType.id = et.id")
    List<EventList> findEventsQuery();
}
