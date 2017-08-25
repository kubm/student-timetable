package com.kubacki.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LessonList implements Serializable, SchedulerEvent{
    private Integer id;
    private String start_date;
    private String end_date;
    private String text;
    private String details;
    private String rec_type;
    private Long event_length;
    private Integer event_pid;
    private String type;
    private boolean allDay;







    public LessonList(Integer id, String subject, String type, Date start, Date end, String startTime, String endTime, Colour colour){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date startTimeDate = new Date();
        Date endTimeDate = new Date();
        try {
            startTimeDate = timeFormat.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            endTimeDate = timeFormat.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.id = id;
        this.text = subject+" - "+type;
        String startDateString = df.format(start);
        String endDateString = df.format(end);

        this.start_date = startDateString+" "+startTime;
        this.end_date = endDateString+" "+endTime;
        this.allDay=false;
        this.event_length=(endTimeDate.getTime()-startTimeDate.getTime())/1000;
        this.details="";
        this.event_pid=0;
        this.rec_type="day_7___";
        this.type=colour.getName();

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
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
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
    public boolean getAllDay() {
        return allDay;
    }

    @Override
    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    public String getRec_type() {
        return rec_type;
    }

    public void setRec_type(String rec_type) {
        this.rec_type = rec_type;
    }

    public Long getEvent_length() {
        return event_length;
    }

    public void setEvent_length(Long event_length) {
        this.event_length = event_length;
    }

    public Integer getEvent_pid() {
        return event_pid;
    }

    public void setEvent_pid(Integer event_pid) {
        this.event_pid = event_pid;
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
}
