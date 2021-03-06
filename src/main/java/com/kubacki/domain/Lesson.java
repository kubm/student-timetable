package com.kubacki.domain;



import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;


/**
 * Created by KUBACM on 2017-07-15.
 */
@Entity
public class Lesson implements DomainObject, Comparable<Lesson>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "weekDay")
    //@Formula("(select dayofweek(l.start_date) from Lesson l where l.id = id)")
    //@Persistent
    private Integer weekDay;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date start_date;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date end_date;


    private String start_hour;
    private String end_hour;

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


    @Override
    public int compareTo(Lesson o) {
        return Integer.compare(this.weekDay,o.weekDay);
    }

    //-------------- Getters & Setters ---------------------------//

    public void calculateDayOfWeek(){
        Calendar c = Calendar.getInstance();
        c.setTime(start_date);
        this.weekDay = c.get(Calendar.DAY_OF_WEEK);
    }

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

    public Integer getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Integer weekDay){
        this.weekDay = weekDay;
    }

    public void setWeekDay(Date start_date) {
        Calendar c = Calendar.getInstance();
        c.setTime(start_date);
        this.weekDay = c.get(Calendar.DAY_OF_WEEK);
    }


    public void setWeekDay(){
        Calendar c = Calendar.getInstance();
        c.setTime(this.start_date);
        this.weekDay = c.get(Calendar.DAY_OF_WEEK);
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {

        this.start_date = start_date;
        calculateDayOfWeek();
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
