package com.kubacki.services;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.LessonList;

import java.util.List;

public interface LessonPrinterService {
    public List<LessonList> findByQuery(Integer id);
    public Integer numOfMinutes(Integer weekDay, Integer id);
}
