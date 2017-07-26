package com.kubacki.domain;

import javax.persistence.Entity;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LessonList implements Serializable{
    private Integer id;
    private String title;
    private String start;
    private String end;
    private boolean allDay;





    public LessonList(Integer id, String subject, String type, Date start, Date end, String startTime, String endTime){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        this.id = id;
        this.title = subject+" - "+type;
        String startDateString = df.format(start);
        String endDateString = df.format(end);

        this.start = startDateString+" "+startTime;
        this.end = endDateString+" "+endTime;
        this.allDay=false;

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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }
}
