package com.kubacki.domain;

import com.google.common.primitives.Ints;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dzien;

    private String hour;

    private String endHour;

    private Integer ocena;

    @Column(name = "daysLeft")
    private Integer daysLeft;

    //-------------- Getters & Setters ---------------------------//
    public void calculateDaysLeft(){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        long diff = dzien.getTime() - today.getTime();
        long diffDays = diff/(1000 * 60 * 60 * 24);
        this.daysLeft = Ints.checkedCast(diffDays);
    }

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
        calculateDaysLeft();
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
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

    public Integer getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(Integer daysLeft) {
        this.daysLeft = daysLeft;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }
}
