package com.kubacki.repositories;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.LessonList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonPrinterRepository extends JpaRepository<Lesson, Long>{
    @Query(value = "select new com.kubacki.domain.LessonList(l.id, s.name, lt.nazwa) from Lesson l, Subject s, LessonType lt where l.subject.id = s.id and l.lessonType.id = lt.id")
    List<LessonList> findLessonsQuery();
}
