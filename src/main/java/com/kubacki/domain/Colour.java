package com.kubacki.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Colour implements DomainObject{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "colour")
    private Set<Subject> subjects;

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

    public Set<Subject> getSubjects(){
        return subjects;
    }

    public void addSubject(Subject subject){
        this.subjects.add(subject);
        if(subject.getColour()!=this){
            subject.setColour(this);
        }
    }
}
