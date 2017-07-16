package com.kubacki.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by KUBACM on 2017-07-16.
 */
@Entity
public class Evaluation implements DomainObject{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "evalType_id")
    private EvalType evaluationType;


    @Column(name = "DZIEN", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dzien;
    private Integer ocena;

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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDzien() {
        return dzien;
    }

    public void setDzien(Date dzien) {
        this.dzien = dzien;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public EvalType getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(EvalType evaluationType) {
        this.evaluationType = evaluationType;
    }
}
