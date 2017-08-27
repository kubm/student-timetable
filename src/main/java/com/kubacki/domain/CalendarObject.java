package com.kubacki.domain;

import java.util.List;

public interface CalendarObject {

    public Integer getId();
    public void setId(Integer id);
    public String getTitle();
    public void setTitle(String title);
    public String getStart();
    public void setStart(String start);
    public String getEnd();
    public void setEnd(String end);
    public boolean getAllDay();
    public void setAllDay(boolean allDay);
    public String getDow();
    public void setDow(String dow);
    public List<DateRange> getRanges();
    public void setRanges(List<DateRange> ranges);
    public String getBackgroundColor();
    public void setBackgroundColor(String backgroundColor);
    public String getBorderColor();
    public void setBorderColor(String borderColor);
    public String getTextColor();
    public void setTextColor(String textColor);


}
