package com.kubacki.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Entity
public class Teacher implements DomainObject{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String surname;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "teacher")
    private Set<Lesson> lessons;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Lesson> getLessons(){
        return lessons;
    }

    public void addLesson(Lesson lesson){
        this.lessons.add(lesson);
        if(lesson.getTeacher() != this){
            lesson.setTeacher(this);
        }
    }
}
