package com.kubacki.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LessonList implements Serializable, CalendarObject{
    private Integer id;
    private String title;
    private String start;
    private String end;
    private String dow;
    private boolean allDay;
    private String backgroundColor;
    private String borderColor;
    private String textColor;
    private List<DateRange>ranges;





    public LessonList(Integer id, String subject, String type, Date start, Date end, String startTime, String endTime, Colour colour){
        ranges = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        this.id = id;
        this.title = subject+" - "+type;
        this.start = startTime;
        this.end = endTime;
        String rangeStart = df.format(start);
        String rangeEnd = df.format(end);
        String rangeStartString = "start:"+rangeStart;
        String rangeEndString = "end:"+rangeEnd;
        DateRange range1 = new DateRange(rangeStart,rangeEnd);
        ranges.add(range1);

//        String startDateString = df.format(start);
//        String endDateString = df.format(end);
//
//        this.start = startDateString+" "+startTime;
//        this.end = endDateString+" "+endTime;
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        Integer weekday = c.get(Calendar.DAY_OF_WEEK);
        this.dow="["+(weekday-1)+"]";
        this.allDay=false;
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
    public boolean getAllDay() {
        return allDay;
    }

    @Override
    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
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
    public List<DateRange> getRanges() {
        return ranges;
    }

    @Override
    public void setRanges(List<DateRange> ranges) {
        this.ranges = ranges;
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
}
