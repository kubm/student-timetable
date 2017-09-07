package com.kubacki.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EventList implements Serializable, CalendarObject{
    private Integer id;
    private String title;
    private String start;
    private String end;
    private String dow;
    private boolean allDay;
    private String backgroundColor;
    private String borderColor;
    private String textColor;
    private List<DateRange> ranges;

    public EventList(Integer id, String subjectName, String lessonType, String evalType, Date day, String hour, String endHour, Colour colour){
        ranges = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        this.id = id+400;
        this.title = evalType+": "+subjectName+" - "+lessonType;
        this.start = hour;
        this.end = endHour;
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.add(Calendar.DATE,6);
        Date endDate = cal.getTime();
        String rangeStart = df.format(day);
        String rangeEnd = df.format(endDate);
        DateRange range1 = new DateRange(rangeStart,rangeEnd);
        ranges.add(range1);
        Calendar c = Calendar.getInstance();
        c.setTime(day);
        Integer weekday = c.get(Calendar.DAY_OF_WEEK);
        this.dow="["+(weekday-1)+"]";
        this.allDay = false;
        this.backgroundColor = colour.getHex();
        this.borderColor = colour.getHex();
        this.textColor = "white";

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
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getStart() {
        return start;
    }

    @Override
    public void setStart(String start) {
        this.start = start;
    }

    @Override
    public String getEnd() {
        return end;
    }

    @Override
    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String getDow() {
        return dow;
    }

    @Override
    public void setDow(String dow) {
        this.dow = dow;
    }

    @Override
    public boolean getAllDay() {
        return allDay;
    }

    @Override
    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    @Override
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public String getTextColor() {
        return textColor;
    }

    @Override
    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    @Override
    public List<DateRange> getRanges() {
        return ranges;
    }

    @Override
    public void setRanges(List<DateRange> ranges) {
        this.ranges = ranges;
    }
}
