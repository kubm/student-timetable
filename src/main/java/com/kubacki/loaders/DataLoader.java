package com.kubacki.loaders;

import com.kubacki.domain.Lesson;
import com.kubacki.domain.LessonType;
import com.kubacki.domain.Subject;
import com.kubacki.repositories.HomeworkRepository;
import com.kubacki.repositories.SubjectRepository;
import com.kubacki.repositories.LessonTypeRepository;
import com.kubacki.repositories.LessonRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent>{

    private LessonRepository lessonRepository;
    private SubjectRepository subjectRepository;
    private LessonTypeRepository lessonTypeRepository;
    private HomeworkRepository homeworkRepository;

    private Logger log = Logger.getLogger(DataLoader.class);

    @Autowired
    public void setLessonRepository(LessonRepository lessonRepository){
        this.lessonRepository = lessonRepository;
    }

    @Autowired
    public void setSubjectRepository(SubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    @Autowired
    public void setLessonTypeRepository(LessonTypeRepository lessonTypeRepository){
        this.lessonTypeRepository = lessonTypeRepository;
    }

    @Autowired
    public void setHomeworkRepository(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){
        LessonType lectures = new LessonType();
        lectures.setNazwa("wykłady");
        lessonTypeRepository.save(lectures);
        log.info("Saved lectures");

        LessonType cwiczenia = new LessonType();
        cwiczenia.setNazwa("ćwiczenia");
        lessonTypeRepository.save(cwiczenia);
        log.info("Saved cwiczenia");

        LessonType labs = new LessonType();
        labs.setNazwa("laboratoria");
        lessonTypeRepository.save(labs);
        log.info("Saved labs");


        Subject analiza = new Subject();
        analiza.setName("Analiza Matematyczna");
        analiza.setColour("pommegranate");
        subjectRepository.save(analiza);
        log.info("Saved Analiza Matematyczna");

        Lesson cwiczenia_a = new Lesson();
        cwiczenia_a.setSubject(analiza);
        cwiczenia_a.setDzien_tygodnia("Wtorek");
        cwiczenia_a.setLessonType(cwiczenia);
        lessonRepository.save(cwiczenia_a);
        log.info("Saved cwiczenia");

        Lesson wyklad_a = new Lesson();
        wyklad_a.setSubject(analiza);
        wyklad_a.setDzien_tygodnia("Poniedziałek");
        wyklad_a.setLessonType(lectures);
        lessonRepository.save(wyklad_a);
        log.info("Saved wyklad");
    }
}
