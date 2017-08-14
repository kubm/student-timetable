package com.kubacki.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
public class Subject implements DomainObject{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    //private String colour;

    @OneToMany(mappedBy = "subject")
    private Set<Lesson> lessons;

    @ManyToOne
    @JoinColumn(name = "colour_id")
    private Colour colour;

    //-------------- Getters & Setters ---------------------------//

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    /*public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }*/

    public Set<Lesson> getLessons() {
        return lessons;
    }


    public void addLesson(Lesson lesson){
        this.lessons.add(lesson);
        if(lesson.getSubject() != this){
            lesson.setSubject(this);
        }
    }
}
