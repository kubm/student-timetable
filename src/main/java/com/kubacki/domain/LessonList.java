package com.kubacki.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LessonList implements Serializable{
    private Integer id;
    private String title;
    private String start;
    private String end;
    private String dow;
    private boolean allDay;
    private List<DateRange>ranges;





    public LessonList(Integer id, String subject, String type, Date start, Date end, String startTime, String endTime){
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

    public String getDow() {
        return dow;
    }

    public void setDow(String dow) {
        this.dow = dow;
    }

    public List<DateRange> getRanges() {
        return ranges;
    }

    public void setRanges(List<DateRange> ranges) {
        this.ranges = ranges;
    }
}
