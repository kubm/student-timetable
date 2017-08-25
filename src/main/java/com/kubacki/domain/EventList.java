package com.kubacki.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventList implements Serializable, SchedulerEvent{
    private Integer id;
    private String start_date;
    private String end_date;
    private String text;
    private String details;
    private String type;
    private boolean allDay;

    public EventList(Integer id, String subject, String lessonType, String evalType, Date day, String hour,String endHour, Colour colour){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        this.id = id+400;
        this.text = evalType+": "+subject+" - "+lessonType;
        String startDateString = df.format(day);
        String endDateString = df.format(day);

        this.start_date = startDateString+" "+hour;
        this.end_date = endDateString+" "+endHour;
        this.allDay = false;
        this.details="";
        this.type = colour.getName();
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getStart_date() {
        return start_date;
    }

    @Override
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    @Override
    public String getEnd_date() {
        return end_date;
    }

    @Override
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getDetails() {
        return details;
    }

    @Override
    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean getAllDay() {
        return allDay;
    }

    @Override
    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }
}
