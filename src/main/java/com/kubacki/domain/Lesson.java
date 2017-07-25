package com.kubacki.domain;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Set;


/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
public class Lesson implements DomainObject{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String weekDay;
    private String start_date;
    private String end_date;
    private String start_hour;
    private String end_hour;

    @ManyToOne
    @JoinColumn(name = "type_id")
    @JsonBackReference
    private LessonType lessonType;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonBackReference
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonBackReference
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonBackReference
    private Room room;

    @OneToMany(mappedBy = "lesson")
    @JsonManagedReference
    private Set<Homework> homeworks;

    @OneToMany(mappedBy = "lesson")
    @JsonManagedReference
    private Set<Note> notes;

    @OneToMany(mappedBy = "lesson")
    @JsonManagedReference
    private Set<Evaluation> evaluations;



    //-------------- Getters & Setters ---------------------------//


    public String getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(String start_hour) {
        this.start_hour = start_hour;
    }

    public String getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(String end_hour) {
        this.end_hour = end_hour;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LessonType getLessonType(){
        return lessonType;
    }

    public void setLessonType(LessonType lessonType){
        this.lessonType = lessonType;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Homework> getHomeworks(){
        return homeworks;
    }

    public void addHomework(Homework homework){
        this.homeworks.add(homework);
        if(homework.getLesson() != this){
            homework.setLesson(this);
        }
    }

    public Set<Note> getNotes(){
        return notes;
    }

    public void addNote(Note note){
        this.notes.add(note);
        if(note.getLesson() != this){
            note.setLesson(this);
        }
    }

    public Set<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void addEvaluation(Evaluation evaluation){
        this.evaluations.add(evaluation);
        if(evaluation.getLesson() != this){
            evaluation.setLesson(this);
        }
    }
}
