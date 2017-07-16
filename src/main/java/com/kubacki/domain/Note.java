package com.kubacki.domain;

import javax.persistence.*;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Entity
public class Note implements DomainObject{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "note_id")
    private Lesson lesson;

    private String text;
    //-------------- Getters & Setters ---------------------------//


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
