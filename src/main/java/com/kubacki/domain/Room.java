package com.kubacki.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Entity
public class Room implements DomainObject{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String roomNumber;
    private String building;

    @OneToMany(mappedBy = "room")
    private Set<Lesson> lessons;

    @OneToMany(mappedBy = "room")
    private Set<Evaluation> evaluations;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //-------------- Getters & Setters ---------------------------//


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void addLessons(Lesson lesson){
        this.lessons.add(lesson);
        if(lesson.getRoom() != this){
            lesson.setRoom(this);
        }
    }

    public Set<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void addEvaluations(Evaluation evaluation){
        this.evaluations.add(evaluation);
        if(evaluation.getRoom() != this){
            evaluation.setRoom(this);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
