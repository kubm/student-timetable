package com.kubacki.domain;

import javax.persistence.Entity;
import java.io.Serializable;

public class LessonList implements Serializable{
    private Integer id;
    private String title;



    public LessonList(Integer id, String subject, String type){
        this.id = id;
        this.title = subject+" - "+type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
