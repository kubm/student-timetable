package com.kubacki.repositories;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.LessonList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonPrinterRepository extends JpaRepository<Lesson, Integer>{
    @Query(value = "select new com.kubacki.domain.LessonList(l.id, s.name, lt.nazwa,l.start_date,l.end_date,l.start_hour,l.end_hour,s.colour) " +
            "from Lesson l, Subject s, LessonType lt " +
            "where l.subject.id = s.id and l.lessonType.id = lt.id and s.user.id = :uid")
    List<LessonList> findLessonsQuery(@Param("uid") Integer id);

    @Query(value = "select sum(datediff('s',PARSEDATETIME(l.start_hour,'HH:mm'),PARSEDATETIME(l.end_hour,'HH:mm'))/60) " +
            "from Lesson as l, Subject as s, User as u " +
            "where l.subject_id = s.id and s.user_id = u.id and u.id = ?2 and l.week_day = ?1", nativeQuery=true)
    Integer numOfMinutes(Integer weekDay, Integer id);
}
