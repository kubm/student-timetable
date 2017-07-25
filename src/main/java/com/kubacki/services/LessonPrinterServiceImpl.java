package com.kubacki.services;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.LessonList;
import com.kubacki.repositories.LessonPrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonPrinterServiceImpl implements LessonPrinterService{

    private LessonPrinterRepository lessonPrinterRepository;

    @Autowired
    public void setLessonPrinterRepository(LessonPrinterRepository lessonPrinterRepository){
        this.lessonPrinterRepository = lessonPrinterRepository;
    }

    @Override
    public List<LessonList> findByQuery(){
        return lessonPrinterRepository.findLessonsQuery();
    }
}
