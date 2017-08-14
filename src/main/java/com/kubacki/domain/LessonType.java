package com.kubacki.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Entity
public class LessonType implements DomainObject{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nazwa;

    @OneToMany(mappedBy = "lessonType")
    private Set<Lesson> lesson;

    //-------------- Getters & Setters ---------------------------//

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Set<Lesson> getLesson(){
        return lesson;
    }

    public void addLesson(Lesson lesson){
        this.lesson.add(lesson);
        if(lesson.getLessonType() != this){
            lesson.setLessonType(this);
        }
    }
}
