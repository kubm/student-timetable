package com.kubacki.domain;



import groovy.util.Eval;

import javax.persistence.*;
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

    private String dzien_tygodnia;

    @Column(name = "START_DATE", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start_date;

    @Column(name = "END_DATE", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end_date;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private LessonType lessonType;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "lesson")
    private Set<Homework> homeworks;

    @OneToMany(mappedBy = "lesson")
    private Set<Note> notes;

    @OneToMany(mappedBy = "lesson")
    private Set<Evaluation> evaluations;



    //-------------- Getters & Setters ---------------------------//

    public String getDzien_tygodnia() {
        return dzien_tygodnia;
    }

    public void setDzien_tygodnia(String dzien_tygodnia) {
        this.dzien_tygodnia = dzien_tygodnia;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
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
